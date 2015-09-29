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
import com.baidu.tbadk.core.util.al;
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
import com.baidu.tieba.write.write.cd;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class WriteVoteActivity extends BaseActivity<WriteVoteActivity> implements View.OnClickListener, PopupWindow.OnDismissListener, RadioGroup.OnCheckedChangeListener, BdSwitchView.a, b, c.a, cd.a {
    private com.baidu.tbadk.img.b amf;
    private com.baidu.tieba.tbadkCore.writeModel.a arV;
    private int dlH;
    private n dnn;
    private String dnr;
    private BdToast dnt;
    private PostPrefixData mPrefixData;
    private final WriteData daX = new WriteData();
    private final VoteInfo mVoteInfo = new VoteInfo();
    private final WriteImagesInfo mWriteImagesInfo = new WriteImagesInfo();
    private final WriteImagesInfo dno = new WriteImagesInfo();
    private int dnp = (int) TbadkCoreApplication.m411getInst().getResources().getDimension(i.d.ds80);
    private final ImageOperation dnq = com.baidu.tbadk.img.effect.d.J(this.dnp, this.dnp);
    private DialogInterface.OnCancelListener cpM = null;
    private int dmW = 7;
    private boolean dns = false;
    private int mCurrentTab = 0;
    private final CustomMessageListener dnu = new i(this, CmdConfigCustom.CMD_TEXT_CHANGED);
    private final a.d asj = new j(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        initData();
        this.dnn = new n(this);
        this.dnn.b(this.mPrefixData);
        this.arV = new com.baidu.tieba.tbadkCore.writeModel.a(this);
        this.amf = new com.baidu.tbadk.img.b();
        initListener();
        if (!checkUpIsLogin()) {
            finish();
        } else {
            TiebaStatic.log("c10373");
        }
    }

    private void initListener() {
        this.arV.b(this.asj);
        registerListener(this.dnu);
        this.cpM = new k(this);
    }

    private void initData() {
        Intent intent = getIntent();
        this.daX.setType(6);
        this.daX.setForumId(intent.getStringExtra("forum_id"));
        this.daX.setForumName(intent.getStringExtra("forum_name"));
        this.mPrefixData = (PostPrefixData) intent.getSerializableExtra("prefix_data");
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs() != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.mPrefixData.getPrefixs().add(0, getPageContext().getString(i.h.write_no_prefix));
            this.dlH = 1;
        }
        AntiData antiData = (AntiData) intent.getSerializableExtra("anti");
        if (antiData != null && !TextUtils.isEmpty(antiData.getPollMessage())) {
            com.baidu.adp.lib.util.k.showToast(getPageContext().getPageActivity(), antiData.getPollMessage());
            finish();
        }
    }

    @Override // android.widget.RadioGroup.OnCheckedChangeListener
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        if (this.dnn != null) {
            if (i == i.f.radio_vote_pic) {
                this.dnn.gt(0);
                this.mCurrentTab = 0;
            } else if (i == i.f.radio_vote_text) {
                this.dnn.gt(1);
                this.mCurrentTab = 1;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, PostWriteCallBackData postWriteCallBackData) {
        if (AntiHelper.la(postWriteCallBackData.getErrorCode())) {
            AntiHelper.P(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString());
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
        if (this.dnn != null && view == this.dnn.aCD()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.dns = true;
            } else {
                this.dns = false;
            }
            Lg();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (this.dnn != null) {
            Lg();
            if (view == this.dnn.aCF()) {
                if (this.dnn.aCE() != null) {
                    this.dnn.aCE().showDialog();
                }
            } else if (view == this.dnn.aCG()) {
                if (this.mCurrentTab == 0) {
                    String valueOf = String.valueOf(System.currentTimeMillis());
                    this.dno.clear();
                    this.dno.setMaxImagesAllowed(getMaxImagesAllowed());
                    AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(getPageContext().getPageActivity(), this.dno.toJsonString(), valueOf);
                    albumActivityConfig.setRequestCode(12002);
                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
                } else if (this.mCurrentTab == 1) {
                    this.dnn.mc(1).aCt();
                }
            } else if (view == this.dnn.aCA()) {
                aCw();
            } else if (view == this.dnn.aCy()) {
                this.dnn.aA(view);
            } else if (view == this.dnn.aCz()) {
                this.dnn.aA(view);
            }
        }
    }

    @Override // com.baidu.tieba.write.vote.c.a
    public void O(int i, String str) {
        Lg();
        this.dmW = i;
        if (this.dnn != null) {
            this.dnn.mq(str);
        }
    }

    @Override // com.baidu.tieba.write.vote.b
    public void lX(int i) {
        Lg();
        this.dno.clear();
        this.dno.setMaxImagesAllowed(getMaxImagesAllowed());
        AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(getPageContext().getPageActivity(), this.dno.toJsonString(), String.valueOf(System.currentTimeMillis()), i);
        albumActivityConfig.setRequestCode(12002);
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
    }

    @Override // com.baidu.tieba.write.vote.b
    public void lY(int i) {
        Lg();
        if (this.dnn != null) {
            this.dnn.md(i);
        }
    }

    @Override // com.baidu.tieba.write.vote.b
    public void N(int i, String str) {
        Lg();
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(str);
        sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, new ImageViewerConfig(getPageContext().getPageActivity()).createConfig(arrayList, 0, "", "", "", true, "", true)));
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        if (this.dnn != null) {
            this.dnn.gZ(false);
        }
    }

    @Override // com.baidu.tieba.write.write.cd.a
    public void lQ(int i) {
        this.dlH = i;
        if (this.dnn != null && this.mPrefixData != null) {
            this.dnn.P(i, this.mPrefixData.getPrefixs().get(i));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.dnn != null) {
            this.dnn.dF(i);
        }
    }

    private int getMaxImagesAllowed() {
        ArrayList<g> aCH;
        if (this.dnn == null || (aCH = this.dnn.aCH()) == null) {
            return 10;
        }
        Iterator<g> it = aCH.iterator();
        int i = 0;
        while (it.hasNext()) {
            g next = it.next();
            if (next != null && next.aCq()) {
                i++;
            }
        }
        return 10 - i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBR() {
        if (this.arV != null) {
            this.arV.cancelLoadData();
        }
    }

    private void aCw() {
        aBR();
        if (this.dnn != null && this.arV != null && this.dnn.aCB() != null && this.dnn.aCB() != null) {
            String trim = this.dnn.aCB().getText().toString().trim();
            String trim2 = this.dnn.aCC().getText().toString().trim();
            if (!bj(trim, trim2)) {
                aCx();
                return;
            }
            this.daX.setVoteInfo(this.mVoteInfo);
            this.arV.c(this.daX);
            this.daX.setContent(trim2);
            this.daX.setVcode(null);
            if (this.dlH != 0 && this.mPrefixData != null && this.mPrefixData.getPrefixs() != null && this.mPrefixData.getPrefixs().size() > 0 && this.dnn.aCz() != null) {
                this.daX.setTitle(String.valueOf(this.dnn.aCz().getText().toString()) + trim);
            } else {
                this.daX.setTitle(trim);
            }
            if (TextUtils.isEmpty(this.daX.getTitle())) {
                this.daX.setIsNoTitle(true);
            } else {
                this.daX.setIsNoTitle(false);
            }
            if (!this.arV.axI()) {
                mb(i.h.write_img_limit);
            } else if (this.arV.axF()) {
                showLoadingDialog(getPageContext().getString(i.h.sending), this.cpM);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0020  */
    /* JADX WARN: Removed duplicated region for block: B:55:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean bj(String str, String str2) {
        ArrayList<g> arrayList;
        List<g> aCI;
        int i;
        if (this.dnn == null) {
            return false;
        }
        if (this.mCurrentTab == 0) {
            aCI = this.dnn.aCH();
            if (!f(str2, aCI)) {
                return false;
            }
        } else if (this.mCurrentTab != 1) {
            arrayList = null;
            if (bJ(arrayList)) {
                return false;
            }
            this.mWriteImagesInfo.clear();
            this.mWriteImagesInfo.setMaxImagesAllowed(10);
            this.mVoteInfo.setDescription(str2);
            this.mVoteInfo.setEndtime(this.dmW);
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
                    if (gVar != null && (this.mCurrentTab != 1 || gVar.aCr())) {
                        ImageFileInfo aCu = gVar.aCu();
                        arrayList2.add(new VoteInfo.VoteOption(gVar.getId(), gVar.aCs(), aCu));
                        if (this.mCurrentTab == 0 && aCu != null) {
                            this.mWriteImagesInfo.addChooseFile(aCu);
                            this.mWriteImagesInfo.updateQuality();
                        }
                    }
                }
                this.mVoteInfo.setOptions(arrayList2);
                this.mVoteInfo.setIsMulti(this.dns ? 1 : 0);
                this.daX.setWriteImagesInfo(this.mWriteImagesInfo);
                this.arV.gw(this.mWriteImagesInfo.size() > 0);
                return true;
            }
            return false;
        } else {
            aCI = this.dnn.aCI();
            if (!bI(aCI)) {
                return false;
            }
        }
        arrayList = aCI;
        if (bJ(arrayList)) {
        }
    }

    private boolean f(String str, List<g> list) {
        if (bJ(list)) {
            if (TextUtils.isEmpty(str)) {
                for (g gVar : list) {
                    if (gVar != null) {
                        if (!gVar.aCq()) {
                            gVar.aCt();
                            mb(i.h.vote_item_pic_no_ok);
                            return false;
                        } else if (!gVar.aCr()) {
                            gVar.ma(i.h.vote_hint);
                            mb(i.h.vote_item_no_ok);
                            return false;
                        }
                    }
                }
            } else {
                for (g gVar2 : list) {
                    if (gVar2 != null && !gVar2.aCq()) {
                        gVar2.aCt();
                        mb(i.h.vote_item_pic_no_ok);
                        return false;
                    }
                }
            }
            return true;
        }
        return false;
    }

    private boolean bI(List<g> list) {
        int i;
        if (bJ(list)) {
            g gVar = null;
            int i2 = 0;
            for (g gVar2 : list) {
                if (gVar2 != null) {
                    if (!gVar2.aCr()) {
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
                gVar.ma(i.h.vote_hint);
                return false;
            }
            return false;
        }
        return false;
    }

    private boolean bJ(List<g> list) {
        if (list == null || list.size() == 0) {
            mb(i.h.vote_error_null);
            return false;
        } else if (list.size() < 2) {
            mb(i.h.vote_error_less_two);
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
                this.dno.clear();
            }
        } else if (i2 == 0) {
            Lg();
            switch (i) {
                case 12001:
                    Bt();
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
                    this.dnr = String.valueOf(System.currentTimeMillis());
                    al.a(getPageContext(), this.dnr);
                    return;
            }
        }
    }

    private void Y(Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
            if (stringExtra != null) {
                this.dno.clear();
                this.dno.parseJson(stringExtra);
                this.dno.updateQuality();
            }
            if (this.dno.size() >= 1) {
                Iterator<ImageFileInfo> it = this.dno.getChosedFiles().iterator();
                while (it.hasNext()) {
                    ImageFileInfo next = it.next();
                    if (next != null) {
                        i(next);
                    }
                }
            }
        }
    }

    private void Z(Intent intent) {
        i(aa(intent));
    }

    private void i(ImageFileInfo imageFileInfo) {
        if (imageFileInfo != null && this.amf != null) {
            imageFileInfo.addPageAction(this.dnq);
            com.baidu.adp.widget.a.a a = this.amf.a(imageFileInfo, false);
            if (a != null) {
                this.dnn.b(imageFileInfo, a);
            } else {
                this.amf.a(imageFileInfo, new l(this, imageFileInfo), false);
            }
        }
    }

    private ImageFileInfo aa(Intent intent) {
        this.dnr = intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME);
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.dnr;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            int cB = com.baidu.tbadk.core.util.c.cB(str);
            if (cB != 0) {
                Bitmap b = com.baidu.tbadk.core.util.c.b(str, com.baidu.adp.lib.util.k.dip2px(getPageContext().getPageActivity(), com.baidu.adp.lib.util.k.K(getPageContext().getPageActivity())), com.baidu.adp.lib.util.k.dip2px(getPageContext().getPageActivity(), com.baidu.adp.lib.util.k.L(getPageContext().getPageActivity())));
                Bitmap i = com.baidu.tbadk.core.util.c.i(b, cB);
                if (b != i) {
                    b.recycle();
                }
                com.baidu.tbadk.core.util.n.a(TbConfig.LOCAL_CAMERA_DIR, this.dnr, i, 100);
                i.recycle();
            }
        } catch (Exception e) {
        }
        ImageFileInfo imageFileInfo = new ImageFileInfo();
        imageFileInfo.setFilePath(str);
        imageFileInfo.setTempFile(true);
        return imageFileInfo;
    }

    private void Bt() {
        new m(this).execute(new Void[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.amf != null) {
            this.amf.Cm();
        }
        TiebaPrepareImageService.StopService();
        aBR();
        destroyWaitingDialog();
        super.onDestroy();
    }

    private void Lg() {
        if (getCurrentFocus() != null) {
            com.baidu.adp.lib.util.k.c(getPageContext().getPageActivity(), getCurrentFocus());
        }
    }

    private void aCx() {
        if (getCurrentFocus() != null) {
            ShowSoftKeyPadDelay(getCurrentFocus(), SocialAPIErrorCodes.ERROR_AUTHORIZATION_CANCELED);
        }
    }

    private void mp(String str) {
        if (this.dnt == null) {
            this.dnt = BdToast.a(getApplicationContext(), 48, 0, 350);
        }
        this.dnt.c(str);
        this.dnt.sZ();
    }

    private void mb(int i) {
        mp(getApplicationContext().getResources().getString(i));
    }
}
