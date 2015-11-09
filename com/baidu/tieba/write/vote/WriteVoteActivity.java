package com.baidu.tieba.write.vote;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.RadioGroup;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.cloudsdk.social.core.util.SocialAPIErrorCodes;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.service.TiebaPrepareImageService;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.coreExtra.data.VoteInfo;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.img.effect.ImageOperation;
import com.baidu.tieba.i;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.writeModel.a;
import com.baidu.tieba.write.vote.c;
import com.baidu.tieba.write.write.cf;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class WriteVoteActivity extends BaseActivity<WriteVoteActivity> implements View.OnClickListener, PopupWindow.OnDismissListener, RadioGroup.OnCheckedChangeListener, BdSwitchView.a, b, c.a, cf.a {
    private com.baidu.tbadk.img.b aml;
    private com.baidu.tieba.tbadkCore.writeModel.a aqv;
    private int dnP;
    private n dpC;
    private String dpG;
    private BdToast dpI;
    private PostPrefixData mPrefixData;
    private final WriteData ddI = new WriteData();
    private final VoteInfo mVoteInfo = new VoteInfo();
    private final WriteImagesInfo mWriteImagesInfo = new WriteImagesInfo();
    private final WriteImagesInfo dpD = new WriteImagesInfo();
    private int dpE = (int) TbadkCoreApplication.m411getInst().getResources().getDimension(i.d.ds80);
    private final ImageOperation dpF = com.baidu.tbadk.img.effect.d.J(this.dpE, this.dpE);
    private DialogInterface.OnCancelListener crt = null;
    private int dpl = 7;
    private boolean dpH = false;
    private int mCurrentTab = 0;
    private final CustomMessageListener dpJ = new i(this, CmdConfigCustom.CMD_TEXT_CHANGED);
    private final a.d aqM = new j(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        initData();
        this.dpC = new n(this);
        this.dpC.b(this.mPrefixData);
        this.aqv = new com.baidu.tieba.tbadkCore.writeModel.a(this);
        this.aml = new com.baidu.tbadk.img.b();
        initListener();
        if (!checkUpIsLogin()) {
            finish();
        } else {
            TiebaStatic.log("c10373");
        }
    }

    private void initListener() {
        this.aqv.b(this.aqM);
        registerListener(this.dpJ);
        this.crt = new k(this);
    }

    private void initData() {
        Intent intent = getIntent();
        this.ddI.setType(6);
        this.ddI.setForumId(intent.getStringExtra("forum_id"));
        this.ddI.setForumName(intent.getStringExtra("forum_name"));
        this.mPrefixData = (PostPrefixData) intent.getSerializableExtra("prefix_data");
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs() != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.mPrefixData.getPrefixs().add(0, getPageContext().getString(i.h.write_no_prefix));
            this.dnP = 1;
        }
        AntiData antiData = (AntiData) intent.getSerializableExtra("anti");
        if (antiData != null && !TextUtils.isEmpty(antiData.getPollMessage())) {
            com.baidu.adp.lib.util.k.showToast(getPageContext().getPageActivity(), antiData.getPollMessage());
            finish();
        }
    }

    @Override // android.widget.RadioGroup.OnCheckedChangeListener
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        if (this.dpC != null) {
            if (i == i.f.radio_vote_pic) {
                this.dpC.gG(0);
                this.mCurrentTab = 0;
            } else if (i == i.f.radio_vote_text) {
                this.dpC.gG(1);
                this.mCurrentTab = 1;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, PostWriteCallBackData postWriteCallBackData) {
        if (AntiHelper.lr(postWriteCallBackData.getErrorCode())) {
            AntiHelper.Q(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString());
        } else if (postWriteCallBackData.getErrorCode() != 0) {
            String errorString = postWriteCallBackData.getErrorString();
            if (TextUtils.isEmpty(errorString)) {
                errorString = getPageContext().getPageActivity().getString(i.h.error_write);
            }
            showToast(errorString);
        } else {
            com.baidu.tieba.tbadkCore.writeModel.e.d(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (this.dpC != null && view == this.dpC.aDB()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.dpH = true;
            } else {
                this.dpH = false;
            }
            Ls();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (this.dpC != null) {
            Ls();
            if (view == this.dpC.aDD()) {
                if (this.dpC.aDC() != null) {
                    this.dpC.aDC().showDialog();
                }
            } else if (view == this.dpC.aDE()) {
                if (this.mCurrentTab == 0) {
                    String valueOf = String.valueOf(System.currentTimeMillis());
                    this.dpD.clear();
                    this.dpD.setMaxImagesAllowed(getMaxImagesAllowed());
                    AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(getPageContext().getPageActivity(), this.dpD.toJsonString(), valueOf);
                    albumActivityConfig.setRequestCode(12002);
                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
                } else if (this.mCurrentTab == 1) {
                    this.dpC.ms(1).aDr();
                }
            } else if (view == this.dpC.aDy()) {
                aDu();
            } else if (view == this.dpC.aDw()) {
                this.dpC.az(view);
            } else if (view == this.dpC.aDx()) {
                this.dpC.az(view);
            }
        }
    }

    @Override // com.baidu.tieba.write.vote.c.a
    public void P(int i, String str) {
        Ls();
        this.dpl = i;
        if (this.dpC != null) {
            this.dpC.mx(str);
        }
    }

    @Override // com.baidu.tieba.write.vote.b
    public void mn(int i) {
        Ls();
        this.dpD.clear();
        this.dpD.setMaxImagesAllowed(getMaxImagesAllowed());
        AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(getPageContext().getPageActivity(), this.dpD.toJsonString(), String.valueOf(System.currentTimeMillis()), i);
        albumActivityConfig.setRequestCode(12002);
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
    }

    @Override // com.baidu.tieba.write.vote.b
    public void mo(int i) {
        Ls();
        if (this.dpC != null) {
            this.dpC.mt(i);
        }
    }

    @Override // com.baidu.tieba.write.vote.b
    public void O(int i, String str) {
        Ls();
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(str);
        sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, new ImageViewerConfig(getPageContext().getPageActivity()).createConfig(arrayList, 0, "", "", "", true, "", true)));
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        if (this.dpC != null) {
            this.dpC.hc(false);
        }
    }

    @Override // com.baidu.tieba.write.write.cf.a
    public void mg(int i) {
        this.dnP = i;
        if (this.dpC != null && this.mPrefixData != null) {
            this.dpC.Q(i, this.mPrefixData.getPrefixs().get(i));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.dpC != null) {
            this.dpC.dF(i);
        }
    }

    private int getMaxImagesAllowed() {
        ArrayList<g> aDF;
        if (this.dpC == null || (aDF = this.dpC.aDF()) == null) {
            return 10;
        }
        Iterator<g> it = aDF.iterator();
        int i = 0;
        while (it.hasNext()) {
            g next = it.next();
            if (next != null && next.aDo()) {
                i++;
            }
        }
        return 10 - i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aCN() {
        if (this.aqv != null) {
            this.aqv.cancelLoadData();
        }
    }

    private void aDu() {
        aCN();
        if (this.dpC != null && this.aqv != null && this.dpC.aDz() != null && this.dpC.aDz() != null) {
            String trim = this.dpC.aDz().getText().toString().trim();
            String trim2 = this.dpC.aDA().getText().toString().trim();
            if (!bi(trim, trim2)) {
                aDv();
                return;
            }
            this.ddI.setVoteInfo(this.mVoteInfo);
            this.aqv.c(this.ddI);
            this.ddI.setContent(trim2);
            this.ddI.setVcode(null);
            if (this.dnP != 0 && this.mPrefixData != null && this.mPrefixData.getPrefixs() != null && this.mPrefixData.getPrefixs().size() > 0 && this.dpC.aDx() != null) {
                this.ddI.setTitle(String.valueOf(this.dpC.aDx().getText().toString()) + trim);
            } else {
                this.ddI.setTitle(trim);
            }
            if (TextUtils.isEmpty(this.ddI.getTitle())) {
                this.ddI.setIsNoTitle(true);
            } else {
                this.ddI.setIsNoTitle(false);
            }
            if (!this.aqv.ayX()) {
                mr(i.h.write_img_limit);
            } else if (this.aqv.ayU()) {
                showLoadingDialog(getPageContext().getString(i.h.sending), this.crt);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0020  */
    /* JADX WARN: Removed duplicated region for block: B:55:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean bi(String str, String str2) {
        ArrayList<g> arrayList;
        List<g> aDG;
        int i;
        if (this.dpC == null) {
            return false;
        }
        if (this.mCurrentTab == 0) {
            aDG = this.dpC.aDF();
            if (!f(str2, aDG)) {
                return false;
            }
        } else if (this.mCurrentTab != 1) {
            arrayList = null;
            if (bO(arrayList)) {
                return false;
            }
            this.mWriteImagesInfo.clear();
            this.mWriteImagesInfo.setMaxImagesAllowed(10);
            this.mVoteInfo.setDescription(str2);
            this.mVoteInfo.setEndtime(this.dpl);
            if (this.mCurrentTab == 0) {
                i = 2;
            } else {
                i = this.mCurrentTab == 1 ? 1 : -1;
            }
            if (i != -1) {
                this.mVoteInfo.setType(i);
                ArrayList<VoteInfo.VoteOption> arrayList2 = new ArrayList<>();
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    g gVar = arrayList.get(i2);
                    if (gVar != null && (this.mCurrentTab != 1 || gVar.aDp())) {
                        ImageFileInfo aDs = gVar.aDs();
                        arrayList2.add(new VoteInfo.VoteOption(gVar.getId(), gVar.aDq(), aDs));
                        if (this.mCurrentTab == 0 && aDs != null) {
                            this.mWriteImagesInfo.addChooseFile(aDs);
                            this.mWriteImagesInfo.updateQuality();
                        }
                    }
                }
                this.mVoteInfo.setOptions(arrayList2);
                this.mVoteInfo.setIsMulti(this.dpH ? 1 : 0);
                this.ddI.setWriteImagesInfo(this.mWriteImagesInfo);
                this.aqv.gC(this.mWriteImagesInfo.size() > 0);
                return true;
            }
            return false;
        } else {
            aDG = this.dpC.aDG();
            if (!bN(aDG)) {
                return false;
            }
        }
        arrayList = aDG;
        if (bO(arrayList)) {
        }
    }

    private boolean f(String str, List<g> list) {
        if (bO(list)) {
            if (TextUtils.isEmpty(str)) {
                for (g gVar : list) {
                    if (gVar != null) {
                        if (!gVar.aDo()) {
                            gVar.aDr();
                            mr(i.h.vote_item_pic_no_ok);
                            return false;
                        } else if (!gVar.aDp()) {
                            gVar.mq(i.h.vote_hint);
                            mr(i.h.vote_item_no_ok);
                            return false;
                        }
                    }
                }
            } else {
                for (g gVar2 : list) {
                    if (gVar2 != null && !gVar2.aDo()) {
                        gVar2.aDr();
                        mr(i.h.vote_item_pic_no_ok);
                        return false;
                    }
                }
            }
            return true;
        }
        return false;
    }

    private boolean bN(List<g> list) {
        int i;
        if (bO(list)) {
            g gVar = null;
            int i2 = 0;
            for (g gVar2 : list) {
                if (gVar2 != null) {
                    if (!gVar2.aDp()) {
                        if (gVar == null) {
                            i = i2;
                        } else {
                            gVar2 = gVar;
                            i = i2;
                        }
                    } else {
                        gVar2 = gVar;
                        i = i2 + 1;
                    }
                    if (i >= 2) {
                        return true;
                    }
                    i2 = i;
                    gVar = gVar2;
                }
            }
            if (i2 >= 2) {
                return true;
            }
            if (gVar != null) {
                gVar.mq(i.h.vote_hint);
                return false;
            }
            return false;
        }
        return false;
    }

    private boolean bO(List<g> list) {
        if (list == null || list.size() == 0) {
            mr(i.h.vote_error_null);
            return false;
        } else if (list.size() < 2) {
            mr(i.h.vote_error_less_two);
            return false;
        } else {
            return true;
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if (i == 12006) {
                setResult(-1, intent);
                finish();
            } else if (i == 12002 && intent != null) {
                intent.getIntExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, 0);
                if (intent.getBooleanExtra(AlbumActivityConfig.CAMERA_RESULT, false)) {
                    Z(intent);
                } else {
                    Y(intent);
                }
                this.dpD.clear();
            }
        } else if (i2 == 0) {
            Ls();
            switch (i) {
                case 12001:
                    Bh();
                    return;
                case 12002:
                case 12003:
                case 12004:
                case 12005:
                case 12006:
                case 12007:
                case 12008:
                case 12009:
                case 12011:
                case 12012:
                default:
                    return;
                case 12010:
                    this.dpG = String.valueOf(System.currentTimeMillis());
                    am.a(getPageContext(), this.dpG);
                    return;
            }
        }
    }

    private void Y(Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
            if (stringExtra != null) {
                this.dpD.clear();
                this.dpD.parseJson(stringExtra);
                this.dpD.updateQuality();
            }
            if (this.dpD.size() >= 1) {
                Iterator<ImageFileInfo> it = this.dpD.getChosedFiles().iterator();
                while (it.hasNext()) {
                    ImageFileInfo next = it.next();
                    if (next != null) {
                        j(next);
                    }
                }
            }
        }
    }

    private void Z(Intent intent) {
        j(aa(intent));
    }

    private void j(ImageFileInfo imageFileInfo) {
        if (imageFileInfo != null && this.aml != null) {
            imageFileInfo.addPageAction(this.dpF);
            com.baidu.adp.widget.a.a a = this.aml.a(imageFileInfo, false);
            if (a != null) {
                this.dpC.b(imageFileInfo, a);
            } else {
                this.aml.a(imageFileInfo, new l(this, imageFileInfo), false);
            }
        }
    }

    private ImageFileInfo aa(Intent intent) {
        this.dpG = intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME);
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.dpG;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            int cC = com.baidu.tbadk.core.util.c.cC(str);
            if (cC != 0) {
                Bitmap b = com.baidu.tbadk.core.util.c.b(str, com.baidu.adp.lib.util.k.dip2px(getPageContext().getPageActivity(), com.baidu.adp.lib.util.k.K(getPageContext().getPageActivity())), com.baidu.adp.lib.util.k.dip2px(getPageContext().getPageActivity(), com.baidu.adp.lib.util.k.L(getPageContext().getPageActivity())));
                Bitmap i = com.baidu.tbadk.core.util.c.i(b, cC);
                if (b != i) {
                    b.recycle();
                }
                com.baidu.tbadk.core.util.n.a(TbConfig.LOCAL_CAMERA_DIR, this.dpG, i, 100);
                i.recycle();
            }
        } catch (Exception e) {
        }
        ImageFileInfo imageFileInfo = new ImageFileInfo();
        imageFileInfo.setFilePath(str);
        imageFileInfo.setTempFile(true);
        return imageFileInfo;
    }

    private void Bh() {
        new m(this).execute(new Void[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.aml != null) {
            this.aml.Cc();
        }
        TiebaPrepareImageService.StopService();
        aCN();
        destroyWaitingDialog();
        super.onDestroy();
    }

    private void Ls() {
        if (getCurrentFocus() != null) {
            com.baidu.adp.lib.util.k.c(getPageContext().getPageActivity(), getCurrentFocus());
        }
    }

    private void aDv() {
        if (getCurrentFocus() != null) {
            ShowSoftKeyPadDelay(getCurrentFocus(), SocialAPIErrorCodes.ERROR_AUTHORIZATION_CANCELED);
        }
    }

    private void mw(String str) {
        if (this.dpI == null) {
            this.dpI = BdToast.a(getApplicationContext(), 48, 0, 350);
        }
        this.dpI.c(str);
        this.dpI.sZ();
    }

    private void mr(int i) {
        mw(getApplicationContext().getResources().getString(i));
    }
}
