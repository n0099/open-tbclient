package com.baidu.tieba.write.vote;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.RadioGroup;
import com.baidu.a.a.a;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
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
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ag;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.coreExtra.data.VoteInfo;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.img.effect.ImageOperation;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.writeModel.a;
import com.baidu.tieba.write.vote.c;
import com.baidu.tieba.write.write.cg;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class WriteVoteActivity extends BaseActivity<WriteVoteActivity> implements View.OnClickListener, PopupWindow.OnDismissListener, RadioGroup.OnCheckedChangeListener, a.InterfaceC0000a, BdSwitchView.a, b, c.a, cg.a {
    private com.baidu.tbadk.img.b aqL;
    private com.baidu.tieba.tbadkCore.writeModel.a avv;
    private AntiData avy;
    private String eGM;
    private int eIV;
    private o eKQ;
    private BdToast eKV;
    private PostPrefixData mPrefixData;
    private WriteData esv = new WriteData();
    private VoteInfo mVoteInfo = new VoteInfo();
    private final WriteImagesInfo dsL = new WriteImagesInfo();
    private final WriteImagesInfo eKR = new WriteImagesInfo();
    private int eKS = (int) TbadkCoreApplication.m411getInst().getResources().getDimension(t.e.ds80);
    private final ImageOperation eKT = com.baidu.tbadk.img.effect.d.D(this.eKS, this.eKS);
    private DialogInterface.OnCancelListener dtc = null;
    private int eKB = 7;
    private boolean eKU = false;
    private int baX = 0;
    private com.baidu.tbadk.core.view.b aDD = null;
    private final CustomMessageListener eKW = new i(this, CmdConfigCustom.CMD_TEXT_CHANGED);
    private final a.d avL = new j(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        initData(bundle);
        this.aDD = new com.baidu.tbadk.core.view.b(getPageContext());
        this.eKQ = new o(this);
        this.eKQ.b(this.mPrefixData);
        this.avv = new com.baidu.tieba.tbadkCore.writeModel.a(this);
        this.aqL = new com.baidu.tbadk.img.b();
        pf();
        if (!checkUpIsLogin()) {
            finish();
            return;
        }
        Ze();
        this.eKQ.gg(this.baX);
        adjustResizeForSoftInput();
        TiebaStatic.log("c10373");
    }

    private void Ze() {
        if (this.eKQ != null) {
            if (this.esv == null) {
                this.eKQ.baV();
                return;
            }
            this.eKQ.baM().setText(this.esv.getTitle());
            this.eKQ.baN().setText(this.esv.getContent());
            this.eKQ.baR().setText(c.qI(this.eKB));
            if (this.eKU) {
                this.eKQ.baO().mi();
            } else {
                this.eKQ.baO().mj();
            }
            if (this.mVoteInfo != null && !y.q(this.mVoteInfo.getOptions())) {
                c(this.mVoteInfo.getOptions(), this.mVoteInfo.getType());
                this.eKQ.baW();
                return;
            }
            this.eKQ.baV();
        }
    }

    private void c(ArrayList<VoteInfo.VoteOption> arrayList, int i) {
        if (!y.q(arrayList)) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < arrayList.size()) {
                    VoteInfo.VoteOption voteOption = arrayList.get(i3);
                    if (i == 2) {
                        a(voteOption.imageFileInfo, voteOption.text);
                    } else {
                        this.eKQ.oW(voteOption.text);
                    }
                    i2 = i3 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private void a(ImageFileInfo imageFileInfo, String str) {
        if (imageFileInfo != null && this.aqL != null) {
            imageFileInfo.addPageAction(this.eKT);
            com.baidu.adp.widget.a.a a = this.aqL.a(imageFileInfo, false);
            if (a != null) {
                this.eKQ.a(imageFileInfo, a, str);
            } else {
                this.aqL.a(imageFileInfo, new k(this, imageFileInfo, str), false);
            }
        }
    }

    private void pf() {
        this.avv.b(this.avL);
        registerListener(this.eKW);
        this.dtc = new l(this);
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            this.baX = bundle.getInt("key_current_tab");
            this.esv = (WriteData) bundle.getSerializable("key_current_data");
            if (this.esv != null && this.esv.getVoteInfo() != null) {
                this.mVoteInfo = this.esv.getVoteInfo();
                this.eKB = this.mVoteInfo.getEndtime();
                this.eKU = this.mVoteInfo.getIsMulti() == 1;
            }
            this.mPrefixData = (PostPrefixData) bundle.getSerializable("key_current_prefix_data");
            return;
        }
        Intent intent = getIntent();
        this.esv.setType(6);
        this.esv.setForumId(intent.getStringExtra("forum_id"));
        this.esv.setForumName(intent.getStringExtra("forum_name"));
        this.mPrefixData = (PostPrefixData) intent.getSerializableExtra("prefix_data");
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs() != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.mPrefixData.getPrefixs().add(0, getPageContext().getString(t.j.write_no_prefix));
            this.eIV = 1;
        }
        this.avy = (AntiData) intent.getSerializableExtra("anti");
        if (this.avy != null && !TextUtils.isEmpty(this.avy.getPollMessage())) {
            com.baidu.adp.lib.util.k.showToast(getPageContext().getPageActivity(), this.avy.getPollMessage());
            finish();
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle == null) {
            bundle = new Bundle();
        }
        baG();
        bundle.putInt("key_current_tab", this.baX);
        bundle.putSerializable("key_current_data", this.esv);
        bundle.putSerializable("key_current_prefix_data", this.mPrefixData);
    }

    private void baG() {
        ArrayList<g> arrayList;
        String trim = this.eKQ.baM().getText().toString().trim();
        String trim2 = this.eKQ.baN().getText().toString().trim();
        this.esv.setTitle(trim);
        this.esv.setContent(trim2);
        this.dsL.clear();
        this.dsL.setMaxImagesAllowed(10);
        this.mVoteInfo.setDescription(trim2);
        this.mVoteInfo.setEndtime(this.eKB);
        if (this.baX == 0) {
            arrayList = this.eKQ.baT();
        } else if (this.baX != 1) {
            arrayList = null;
        } else {
            arrayList = this.eKQ.baU();
        }
        int i = -1;
        if (this.baX == 0) {
            i = 2;
        } else if (this.baX == 1) {
            i = 1;
        }
        this.mVoteInfo.setType(i);
        ArrayList<VoteInfo.VoteOption> arrayList2 = new ArrayList<>();
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            g gVar = arrayList.get(i2);
            if (gVar != null && (this.baX != 1 || gVar.baC())) {
                ImageFileInfo Yp = gVar.Yp();
                arrayList2.add(new VoteInfo.VoteOption(gVar.getId(), gVar.baD(), Yp));
                if (this.baX == 0 && Yp != null) {
                    this.dsL.addChooseFile(Yp);
                    this.dsL.updateQuality();
                }
            }
        }
        this.mVoteInfo.setOptions(arrayList2);
        this.mVoteInfo.setIsMulti(this.eKU ? 1 : 0);
        this.avv.iN(this.dsL.size() > 0);
        this.esv.setWriteImagesInfo(this.dsL);
        this.esv.setVoteInfo(this.mVoteInfo);
    }

    @Override // android.widget.RadioGroup.OnCheckedChangeListener
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        if (this.eKQ != null) {
            if (i == t.g.radio_vote_pic) {
                this.eKQ.gg(0);
                this.baX = 0;
            } else if (i == t.g.radio_vote_text) {
                this.eKQ.gg(1);
                this.baX = 1;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, PostWriteCallBackData postWriteCallBackData) {
        if (AntiHelper.pB(postWriteCallBackData.getErrorCode())) {
            AntiHelper.O(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString());
        } else if (postWriteCallBackData.getErrorCode() != 0) {
            String errorString = postWriteCallBackData.getErrorString();
            if (TextUtils.isEmpty(errorString)) {
                errorString = getPageContext().getPageActivity().getString(t.j.error_write);
            }
            showToast(errorString);
        } else {
            com.baidu.tieba.tbadkCore.writeModel.e.b(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        String str;
        if (this.eKQ != null) {
            String string = getResources().getString(t.j.vote_multiple);
            if (view == this.eKQ.baO() && this.eKQ.baP() != null) {
                if (switchState == BdSwitchView.SwitchState.ON) {
                    this.eKU = true;
                    str = String.valueOf(string) + getResources().getString(t.j.now_state_on);
                } else {
                    this.eKU = false;
                    str = String.valueOf(string) + getResources().getString(t.j.now_state_off);
                }
                this.eKQ.baP().setContentDescription(str);
                QY();
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (this.eKQ != null) {
            QY();
            if (view == this.eKQ.baR()) {
                if (this.eKQ.baQ() != null) {
                    this.eKQ.baQ().Hl();
                }
            } else if (view == this.eKQ.baS()) {
                if (this.baX == 0) {
                    String valueOf = String.valueOf(System.currentTimeMillis());
                    this.eKR.clear();
                    this.eKR.setMaxImagesAllowed(getMaxImagesAllowed());
                    AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(getPageContext().getPageActivity(), this.eKR.toJsonString(), valueOf);
                    albumActivityConfig.setRequestCode(12002);
                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
                } else if (this.baX == 1) {
                    this.eKQ.qL(1).baE();
                }
            } else if (view == this.eKQ.baL()) {
                baH();
            } else if (view == this.eKQ.baJ()) {
                this.eKQ.bl(view);
            } else if (view == this.eKQ.baK()) {
                this.eKQ.bl(view);
            } else if (view == this.eKQ.baP() && this.eKQ.baO() != null) {
                if (this.eKQ.baO().hO()) {
                    this.eKQ.baO().ml();
                } else {
                    this.eKQ.baO().mk();
                }
            }
        }
    }

    @Override // com.baidu.tieba.write.vote.c.a
    public void Q(int i, String str) {
        QY();
        this.eKB = i;
        if (this.eKQ != null) {
            this.eKQ.oX(str);
        }
    }

    @Override // com.baidu.tieba.write.vote.b
    public void qF(int i) {
        QY();
        this.eKR.clear();
        this.eKR.setMaxImagesAllowed(getMaxImagesAllowed());
        AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(getPageContext().getPageActivity(), this.eKR.toJsonString(), String.valueOf(System.currentTimeMillis()), i);
        albumActivityConfig.setRequestFrom(3);
        albumActivityConfig.setRequestCode(12002);
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
    }

    @Override // com.baidu.tieba.write.vote.b
    public void qG(int i) {
        QY();
        if (this.eKQ != null) {
            this.eKQ.qM(i);
        }
    }

    @Override // com.baidu.tieba.write.vote.b
    public void P(int i, String str) {
        QY();
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(str);
        sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, new ImageViewerConfig(getPageContext().getPageActivity()).createConfig(arrayList, 0, "", "", "", true, "", true)));
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        if (this.eKQ != null) {
            this.eKQ.ju(false);
        }
    }

    @Override // com.baidu.tieba.write.write.cg.a
    public void qy(int i) {
        this.eIV = i;
        if (this.eKQ != null && this.mPrefixData != null) {
            this.eKQ.R(i, this.mPrefixData.getPrefixs().get(i));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.eKQ != null) {
            this.eKQ.em(i);
        }
    }

    private int getMaxImagesAllowed() {
        ArrayList<g> baT;
        if (this.eKQ == null || (baT = this.eKQ.baT()) == null) {
            return 10;
        }
        Iterator<g> it = baT.iterator();
        int i = 0;
        while (it.hasNext()) {
            g next = it.next();
            if (next != null && next.baB()) {
                i++;
            }
        }
        return 10 - i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZP() {
        if (this.avv != null) {
            this.avv.cancelLoadData();
        }
    }

    private void baH() {
        aZP();
        if (this.eKQ != null && this.avv != null && this.eKQ.baM() != null && this.eKQ.baM() != null) {
            String trim = this.eKQ.baM().getText().toString().trim();
            String trim2 = this.eKQ.baN().getText().toString().trim();
            if (!bK(trim, trim2)) {
                baI();
                return;
            }
            this.esv.setVoteInfo(this.mVoteInfo);
            this.avv.d(this.esv);
            this.esv.setContent(trim2);
            this.esv.setVcode(null);
            if (this.eIV != 0 && this.mPrefixData != null && this.mPrefixData.getPrefixs() != null && this.mPrefixData.getPrefixs().size() > 0 && this.eKQ.baK() != null) {
                this.esv.setTitle(String.valueOf(this.eKQ.baK().getText().toString()) + trim);
            } else {
                this.esv.setTitle(trim);
            }
            if (TextUtils.isEmpty(this.esv.getTitle())) {
                this.esv.setIsNoTitle(true);
            } else {
                this.esv.setIsNoTitle(false);
            }
            if (!this.avv.aUJ()) {
                qK(t.j.write_img_limit);
            } else if (this.avv.aUG()) {
                showLoadingDialog(getPageContext().getString(t.j.sending), this.dtc);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0020  */
    /* JADX WARN: Removed duplicated region for block: B:55:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean bK(String str, String str2) {
        ArrayList<g> arrayList;
        List<g> baU;
        int i;
        if (this.eKQ == null) {
            return false;
        }
        if (this.baX == 0) {
            baU = this.eKQ.baT();
            if (!g(str2, baU)) {
                return false;
            }
        } else if (this.baX != 1) {
            arrayList = null;
            if (cI(arrayList)) {
                return false;
            }
            this.dsL.clear();
            this.dsL.setMaxImagesAllowed(10);
            this.mVoteInfo.setDescription(str2);
            this.mVoteInfo.setEndtime(this.eKB);
            if (this.baX == 0) {
                i = 2;
            } else {
                i = this.baX == 1 ? 1 : -1;
            }
            if (i != -1) {
                this.mVoteInfo.setType(i);
                ArrayList<VoteInfo.VoteOption> arrayList2 = new ArrayList<>();
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    g gVar = arrayList.get(i2);
                    if (gVar != null && (this.baX != 1 || gVar.baC())) {
                        ImageFileInfo Yp = gVar.Yp();
                        arrayList2.add(new VoteInfo.VoteOption(gVar.getId(), gVar.baD(), Yp));
                        if (this.baX == 0 && Yp != null) {
                            this.dsL.addChooseFile(Yp);
                            this.dsL.updateQuality();
                        }
                    }
                }
                this.mVoteInfo.setOptions(arrayList2);
                this.mVoteInfo.setIsMulti(this.eKU ? 1 : 0);
                this.esv.setWriteImagesInfo(this.dsL);
                this.avv.iN(this.dsL.size() > 0);
                return true;
            }
            return false;
        } else {
            baU = this.eKQ.baU();
            if (!cH(baU)) {
                return false;
            }
        }
        arrayList = baU;
        if (cI(arrayList)) {
        }
    }

    private boolean g(String str, List<g> list) {
        if (cI(list)) {
            if (TextUtils.isEmpty(str)) {
                for (g gVar : list) {
                    if (gVar != null) {
                        if (!gVar.baB()) {
                            gVar.baE();
                            qK(t.j.vote_item_pic_no_ok);
                            return false;
                        } else if (!gVar.baC()) {
                            gVar.qJ(t.j.vote_hint);
                            qK(t.j.vote_item_no_ok);
                            return false;
                        }
                    }
                }
            } else {
                for (g gVar2 : list) {
                    if (gVar2 != null && !gVar2.baB()) {
                        gVar2.baE();
                        qK(t.j.vote_item_pic_no_ok);
                        return false;
                    }
                }
            }
            return true;
        }
        return false;
    }

    private boolean cH(List<g> list) {
        int i;
        if (cI(list)) {
            g gVar = null;
            int i2 = 0;
            for (g gVar2 : list) {
                if (gVar2 != null) {
                    if (!gVar2.baC()) {
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
                gVar.qJ(t.j.vote_hint);
                return false;
            }
            return false;
        }
        return false;
    }

    private boolean cI(List<g> list) {
        if (list == null || list.size() == 0) {
            qK(t.j.vote_error_null);
            return false;
        } else if (list.size() < 2) {
            qK(t.j.vote_error_less_two);
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
                    z(intent);
                } else {
                    y(intent);
                }
                this.eKR.clear();
            }
        } else if (i2 == 0) {
            QY();
            switch (i) {
                case 12001:
                    DV();
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
                    this.eGM = String.valueOf(System.currentTimeMillis());
                    oK(this.eGM);
                    return;
            }
        }
    }

    private void oK(String str) {
        if (!ag.c(getPageContext().getPageActivity(), 1)) {
            as.b(getPageContext(), str);
        }
    }

    private void y(Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
            if (stringExtra != null) {
                this.eKR.clear();
                this.eKR.parseJson(stringExtra);
                this.eKR.updateQuality();
            }
            if (this.eKR.size() >= 1) {
                Iterator<ImageFileInfo> it = this.eKR.getChosedFiles().iterator();
                while (it.hasNext()) {
                    ImageFileInfo next = it.next();
                    if (next != null) {
                        j(next);
                    }
                }
            }
        }
    }

    private void z(Intent intent) {
        j(A(intent));
    }

    private void j(ImageFileInfo imageFileInfo) {
        if (imageFileInfo != null && this.aqL != null) {
            imageFileInfo.addPageAction(this.eKT);
            com.baidu.adp.widget.a.a a = this.aqL.a(imageFileInfo, false);
            if (a != null) {
                this.eKQ.b(imageFileInfo, a);
            } else {
                this.aqL.a(imageFileInfo, new m(this, imageFileInfo), false);
            }
        }
    }

    private ImageFileInfo A(Intent intent) {
        this.eGM = intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME);
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.eGM;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            int readPictureDegree = BitmapHelper.readPictureDegree(str);
            if (readPictureDegree != 0) {
                Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, com.baidu.adp.lib.util.k.dip2px(getPageContext().getPageActivity(), com.baidu.adp.lib.util.k.B(getPageContext().getPageActivity())), com.baidu.adp.lib.util.k.dip2px(getPageContext().getPageActivity(), com.baidu.adp.lib.util.k.C(getPageContext().getPageActivity())));
                Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                if (loadResizedBitmap != rotateBitmapBydegree) {
                    loadResizedBitmap.recycle();
                }
                com.baidu.tbadk.core.util.m.b(TbConfig.LOCAL_CAMERA_DIR, this.eGM, rotateBitmapBydegree, 100);
                rotateBitmapBydegree.recycle();
            }
        } catch (Exception e) {
        }
        ImageFileInfo imageFileInfo = new ImageFileInfo();
        imageFileInfo.setFilePath(str);
        imageFileInfo.setTempFile(true);
        return imageFileInfo;
    }

    private void DV() {
        new n(this).execute(new Void[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.aqL != null) {
            this.aqL.EU();
        }
        TiebaPrepareImageService.StopService();
        aZP();
        destroyWaitingDialog();
        super.onDestroy();
    }

    private void QY() {
        if (getCurrentFocus() != null) {
            com.baidu.adp.lib.util.k.c(getPageContext().getPageActivity(), getCurrentFocus());
        }
    }

    private void baI() {
        if (getCurrentFocus() != null) {
            ShowSoftKeyPadDelay(getCurrentFocus(), 150);
        }
    }

    private void oV(String str) {
        if (this.eKV == null) {
            this.eKV = BdToast.a(getApplicationContext(), 48, 0, 350);
        }
        this.eKV.b(str);
        this.eKV.ux();
    }

    private void qK(int i) {
        oV(getApplicationContext().getResources().getString(i));
    }

    @Override // com.baidu.a.a.a.InterfaceC0000a
    public void a(int i, String[] strArr, int[] iArr) {
        if (i == 1) {
            if (ag.S(getApplicationContext())) {
                if (StringUtils.isNull(this.eGM)) {
                    as.c(getPageContext());
                } else {
                    as.b(getPageContext(), this.eGM);
                }
            } else {
                showToast(t.j.system_permission_prompt_camera);
            }
            ArrayMap<String, Boolean> a = ag.a(strArr, iArr);
            if (a.containsKey("android.permission.WRITE_EXTERNAL_STORAGE") && !a.get("android.permission.WRITE_EXTERNAL_STORAGE").booleanValue()) {
                showToast(t.j.sdcard_permission_denied_advert_for_camera);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        this.aDD.c(null);
        this.aDD.cY(t.j.sending);
        this.aDD.ay(true);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        this.aDD.ay(false);
    }
}
