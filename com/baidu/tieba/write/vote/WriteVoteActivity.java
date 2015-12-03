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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.coreExtra.data.VoteInfo;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.img.effect.ImageOperation;
import com.baidu.tieba.n;
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
    private com.baidu.tbadk.img.b anY;
    private com.baidu.tieba.tbadkCore.writeModel.a asz;
    private int dMV;
    private n dOF;
    private String dOJ;
    private BdToast dOL;
    private PostPrefixData mPrefixData;
    private final WriteData dBW = new WriteData();
    private final VoteInfo mVoteInfo = new VoteInfo();
    private final WriteImagesInfo mWriteImagesInfo = new WriteImagesInfo();
    private final WriteImagesInfo dOG = new WriteImagesInfo();
    private int dOH = (int) TbadkCoreApplication.m411getInst().getResources().getDimension(n.d.ds80);
    private final ImageOperation dOI = com.baidu.tbadk.img.effect.d.K(this.dOH, this.dOH);
    private DialogInterface.OnCancelListener cKN = null;
    private int dOo = 7;
    private boolean dOK = false;
    private int aQr = 0;
    private final CustomMessageListener dOM = new i(this, CmdConfigCustom.CMD_TEXT_CHANGED);
    private final a.d asP = new j(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        initData();
        this.dOF = new n(this);
        this.dOF.b(this.mPrefixData);
        this.asz = new com.baidu.tieba.tbadkCore.writeModel.a(this);
        this.anY = new com.baidu.tbadk.img.b();
        initListener();
        if (!checkUpIsLogin()) {
            finish();
        } else {
            TiebaStatic.log("c10373");
        }
    }

    private void initListener() {
        this.asz.b(this.asP);
        registerListener(this.dOM);
        this.cKN = new k(this);
    }

    private void initData() {
        Intent intent = getIntent();
        this.dBW.setType(6);
        this.dBW.setForumId(intent.getStringExtra("forum_id"));
        this.dBW.setForumName(intent.getStringExtra("forum_name"));
        this.mPrefixData = (PostPrefixData) intent.getSerializableExtra("prefix_data");
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs() != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.mPrefixData.getPrefixs().add(0, getPageContext().getString(n.i.write_no_prefix));
            this.dMV = 1;
        }
        AntiData antiData = (AntiData) intent.getSerializableExtra("anti");
        if (antiData != null && !TextUtils.isEmpty(antiData.getPollMessage())) {
            com.baidu.adp.lib.util.k.showToast(getPageContext().getPageActivity(), antiData.getPollMessage());
            finish();
        }
    }

    @Override // android.widget.RadioGroup.OnCheckedChangeListener
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        if (this.dOF != null) {
            if (i == n.f.radio_vote_pic) {
                this.dOF.fw(0);
                this.aQr = 0;
            } else if (i == n.f.radio_vote_text) {
                this.dOF.fw(1);
                this.aQr = 1;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, PostWriteCallBackData postWriteCallBackData) {
        if (AntiHelper.mC(postWriteCallBackData.getErrorCode())) {
            AntiHelper.Q(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString());
        } else if (postWriteCallBackData.getErrorCode() != 0) {
            String errorString = postWriteCallBackData.getErrorString();
            if (TextUtils.isEmpty(errorString)) {
                errorString = getPageContext().getPageActivity().getString(n.i.error_write);
            }
            showToast(errorString);
        } else {
            com.baidu.tieba.tbadkCore.writeModel.e.d(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (this.dOF != null && view == this.dOF.aIY()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.dOK = true;
            } else {
                this.dOK = false;
            }
            MS();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (this.dOF != null) {
            MS();
            if (view == this.dOF.aJa()) {
                if (this.dOF.aIZ() != null) {
                    this.dOF.aIZ().showDialog();
                }
            } else if (view == this.dOF.aJb()) {
                if (this.aQr == 0) {
                    String valueOf = String.valueOf(System.currentTimeMillis());
                    this.dOG.clear();
                    this.dOG.setMaxImagesAllowed(getMaxImagesAllowed());
                    AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(getPageContext().getPageActivity(), this.dOG.toJsonString(), valueOf);
                    albumActivityConfig.setRequestCode(12002);
                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
                } else if (this.aQr == 1) {
                    this.dOF.nE(1).aIO();
                }
            } else if (view == this.dOF.aIV()) {
                aIR();
            } else if (view == this.dOF.aIT()) {
                this.dOF.aI(view);
            } else if (view == this.dOF.aIU()) {
                this.dOF.aI(view);
            }
        }
    }

    @Override // com.baidu.tieba.write.vote.c.a
    public void Q(int i, String str) {
        MS();
        this.dOo = i;
        if (this.dOF != null) {
            this.dOF.ns(str);
        }
    }

    @Override // com.baidu.tieba.write.vote.b
    public void nz(int i) {
        MS();
        this.dOG.clear();
        this.dOG.setMaxImagesAllowed(getMaxImagesAllowed());
        AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(getPageContext().getPageActivity(), this.dOG.toJsonString(), String.valueOf(System.currentTimeMillis()), i);
        albumActivityConfig.setRequestFrom(3);
        albumActivityConfig.setRequestCode(12002);
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
    }

    @Override // com.baidu.tieba.write.vote.b
    public void nA(int i) {
        MS();
        if (this.dOF != null) {
            this.dOF.nF(i);
        }
    }

    @Override // com.baidu.tieba.write.vote.b
    public void P(int i, String str) {
        MS();
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(str);
        sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, new ImageViewerConfig(getPageContext().getPageActivity()).createConfig(arrayList, 0, "", "", "", true, "", true)));
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        if (this.dOF != null) {
            this.dOF.hK(false);
        }
    }

    @Override // com.baidu.tieba.write.write.cf.a
    public void ns(int i) {
        this.dMV = i;
        if (this.dOF != null && this.mPrefixData != null) {
            this.dOF.R(i, this.mPrefixData.getPrefixs().get(i));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.dOF != null) {
            this.dOF.dU(i);
        }
    }

    private int getMaxImagesAllowed() {
        ArrayList<g> aJc;
        if (this.dOF == null || (aJc = this.dOF.aJc()) == null) {
            return 10;
        }
        Iterator<g> it = aJc.iterator();
        int i = 0;
        while (it.hasNext()) {
            g next = it.next();
            if (next != null && next.aIL()) {
                i++;
            }
        }
        return 10 - i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aIk() {
        if (this.asz != null) {
            this.asz.cancelLoadData();
        }
    }

    private void aIR() {
        aIk();
        if (this.dOF != null && this.asz != null && this.dOF.aIW() != null && this.dOF.aIW() != null) {
            String trim = this.dOF.aIW().getText().toString().trim();
            String trim2 = this.dOF.aIX().getText().toString().trim();
            if (!bl(trim, trim2)) {
                aIS();
                return;
            }
            this.dBW.setVoteInfo(this.mVoteInfo);
            this.asz.c(this.dBW);
            this.dBW.setContent(trim2);
            this.dBW.setVcode(null);
            if (this.dMV != 0 && this.mPrefixData != null && this.mPrefixData.getPrefixs() != null && this.mPrefixData.getPrefixs().size() > 0 && this.dOF.aIU() != null) {
                this.dBW.setTitle(String.valueOf(this.dOF.aIU().getText().toString()) + trim);
            } else {
                this.dBW.setTitle(trim);
            }
            if (TextUtils.isEmpty(this.dBW.getTitle())) {
                this.dBW.setIsNoTitle(true);
            } else {
                this.dBW.setIsNoTitle(false);
            }
            if (!this.asz.aEp()) {
                nD(n.i.write_img_limit);
            } else if (this.asz.aEm()) {
                showLoadingDialog(getPageContext().getString(n.i.sending), this.cKN);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0020  */
    /* JADX WARN: Removed duplicated region for block: B:55:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean bl(String str, String str2) {
        ArrayList<g> arrayList;
        List<g> aJd;
        int i;
        if (this.dOF == null) {
            return false;
        }
        if (this.aQr == 0) {
            aJd = this.dOF.aJc();
            if (!h(str2, aJd)) {
                return false;
            }
        } else if (this.aQr != 1) {
            arrayList = null;
            if (cc(arrayList)) {
                return false;
            }
            this.mWriteImagesInfo.clear();
            this.mWriteImagesInfo.setMaxImagesAllowed(10);
            this.mVoteInfo.setDescription(str2);
            this.mVoteInfo.setEndtime(this.dOo);
            if (this.aQr == 0) {
                i = 2;
            } else {
                i = this.aQr == 1 ? 1 : -1;
            }
            if (i != -1) {
                this.mVoteInfo.setType(i);
                ArrayList<VoteInfo.VoteOption> arrayList2 = new ArrayList<>();
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    g gVar = arrayList.get(i2);
                    if (gVar != null && (this.aQr != 1 || gVar.aIM())) {
                        ImageFileInfo aIP = gVar.aIP();
                        arrayList2.add(new VoteInfo.VoteOption(gVar.getId(), gVar.aIN(), aIP));
                        if (this.aQr == 0 && aIP != null) {
                            this.mWriteImagesInfo.addChooseFile(aIP);
                            this.mWriteImagesInfo.updateQuality();
                        }
                    }
                }
                this.mVoteInfo.setOptions(arrayList2);
                this.mVoteInfo.setIsMulti(this.dOK ? 1 : 0);
                this.dBW.setWriteImagesInfo(this.mWriteImagesInfo);
                this.asz.hn(this.mWriteImagesInfo.size() > 0);
                return true;
            }
            return false;
        } else {
            aJd = this.dOF.aJd();
            if (!cb(aJd)) {
                return false;
            }
        }
        arrayList = aJd;
        if (cc(arrayList)) {
        }
    }

    private boolean h(String str, List<g> list) {
        if (cc(list)) {
            if (TextUtils.isEmpty(str)) {
                for (g gVar : list) {
                    if (gVar != null) {
                        if (!gVar.aIL()) {
                            gVar.aIO();
                            nD(n.i.vote_item_pic_no_ok);
                            return false;
                        } else if (!gVar.aIM()) {
                            gVar.nC(n.i.vote_hint);
                            nD(n.i.vote_item_no_ok);
                            return false;
                        }
                    }
                }
            } else {
                for (g gVar2 : list) {
                    if (gVar2 != null && !gVar2.aIL()) {
                        gVar2.aIO();
                        nD(n.i.vote_item_pic_no_ok);
                        return false;
                    }
                }
            }
            return true;
        }
        return false;
    }

    private boolean cb(List<g> list) {
        int i;
        if (cc(list)) {
            g gVar = null;
            int i2 = 0;
            for (g gVar2 : list) {
                if (gVar2 != null) {
                    if (!gVar2.aIM()) {
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
                gVar.nC(n.i.vote_hint);
                return false;
            }
            return false;
        }
        return false;
    }

    private boolean cc(List<g> list) {
        if (list == null || list.size() == 0) {
            nD(n.i.vote_error_null);
            return false;
        } else if (list.size() < 2) {
            nD(n.i.vote_error_less_two);
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
                this.dOG.clear();
            }
        } else if (i2 == 0) {
            MS();
            switch (i) {
                case 12001:
                    Ch();
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
                    this.dOJ = String.valueOf(System.currentTimeMillis());
                    ar.b(getPageContext(), this.dOJ);
                    return;
            }
        }
    }

    private void Y(Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
            if (stringExtra != null) {
                this.dOG.clear();
                this.dOG.parseJson(stringExtra);
                this.dOG.updateQuality();
            }
            if (this.dOG.size() >= 1) {
                Iterator<ImageFileInfo> it = this.dOG.getChosedFiles().iterator();
                while (it.hasNext()) {
                    ImageFileInfo next = it.next();
                    if (next != null) {
                        h(next);
                    }
                }
            }
        }
    }

    private void Z(Intent intent) {
        h(aa(intent));
    }

    private void h(ImageFileInfo imageFileInfo) {
        if (imageFileInfo != null && this.anY != null) {
            imageFileInfo.addPageAction(this.dOI);
            com.baidu.adp.widget.a.a a = this.anY.a(imageFileInfo, false);
            if (a != null) {
                this.dOF.b(imageFileInfo, a);
            } else {
                this.anY.a(imageFileInfo, new l(this, imageFileInfo), false);
            }
        }
    }

    private ImageFileInfo aa(Intent intent) {
        this.dOJ = intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME);
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.dOJ;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            int cK = com.baidu.tbadk.core.util.c.cK(str);
            if (cK != 0) {
                Bitmap b = com.baidu.tbadk.core.util.c.b(str, com.baidu.adp.lib.util.k.dip2px(getPageContext().getPageActivity(), com.baidu.adp.lib.util.k.K(getPageContext().getPageActivity())), com.baidu.adp.lib.util.k.dip2px(getPageContext().getPageActivity(), com.baidu.adp.lib.util.k.L(getPageContext().getPageActivity())));
                Bitmap i = com.baidu.tbadk.core.util.c.i(b, cK);
                if (b != i) {
                    b.recycle();
                }
                com.baidu.tbadk.core.util.n.a(TbConfig.LOCAL_CAMERA_DIR, this.dOJ, i, 100);
                i.recycle();
            }
        } catch (Exception e) {
        }
        ImageFileInfo imageFileInfo = new ImageFileInfo();
        imageFileInfo.setFilePath(str);
        imageFileInfo.setTempFile(true);
        return imageFileInfo;
    }

    private void Ch() {
        new m(this).execute(new Void[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.anY != null) {
            this.anY.Dd();
        }
        TiebaPrepareImageService.StopService();
        aIk();
        destroyWaitingDialog();
        super.onDestroy();
    }

    private void MS() {
        if (getCurrentFocus() != null) {
            com.baidu.adp.lib.util.k.c(getPageContext().getPageActivity(), getCurrentFocus());
        }
    }

    private void aIS() {
        if (getCurrentFocus() != null) {
            ShowSoftKeyPadDelay(getCurrentFocus(), 150);
        }
    }

    private void nr(String str) {
        if (this.dOL == null) {
            this.dOL = BdToast.a(getApplicationContext(), 48, 0, 350);
        }
        this.dOL.c(str);
        this.dOL.tE();
    }

    private void nD(int i) {
        nr(getApplicationContext().getResources().getString(i));
    }
}
