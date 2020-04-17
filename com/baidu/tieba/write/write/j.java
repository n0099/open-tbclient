package com.baidu.tieba.write.write;

import android.content.DialogInterface;
import android.content.Intent;
import android.location.Address;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.c.a;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.AccountAccessActivityConfig;
import com.baidu.tbadk.core.atomData.NewVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.VcodeActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.TransmitForumData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.aa;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.write.transmit.TransmitForumActivityConfig;
import com.baidu.tieba.write.transmit.model.a;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import tbclient.SimpleForum;
/* loaded from: classes2.dex */
public class j {
    private static final Pattern lGs = Pattern.compile("[ ]*http(s)?://([\\w-]+\\.)+[\\w-]+(/[\\w- ./?#%&=]*)?", 2);
    private TbPageContext duG;
    public com.baidu.tieba.write.c hSm;
    private WriteUrlModel lGo;
    private k lGt;
    private com.baidu.tieba.write.model.a lGu;
    private com.baidu.tieba.write.transmit.model.a lGv;
    private com.baidu.tbadk.core.view.a lGw;
    public String mLat;
    public String mLng;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.j.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && view.getId() != 0) {
                if (view.getId() == R.id.icon_invoke_link) {
                    j.this.dhW();
                    TiebaStatic.log(new an("c12169"));
                }
                if (view.getId() == R.id.url_edit_back_view) {
                    j.this.dhV();
                }
            }
        }
    };
    private View.OnClickListener lGx = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.j.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && view.getId() == R.id.url_add) {
                TiebaStatic.log(new an("c12163"));
                String dij = j.this.lGt.dij();
                if (j.lGs.matcher(dij).matches()) {
                    j.this.dhV();
                    j.this.lGu.Mw(dij);
                    j.this.lGt.a(null, true);
                    return;
                }
                TiebaStatic.log(new an("c12164"));
                j.this.lGt.dik();
            }
        }
    };
    private TextWatcher lGy = new TextWatcher() { // from class: com.baidu.tieba.write.write.j.3
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            j.this.lGt.dib();
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (j.this.hSm != null) {
                if (!j.this.hSm.deV()) {
                    j.this.uY(false);
                }
                j.this.hSm.uO(false);
            }
        }
    };
    private DialogInterface.OnCancelListener lGz = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.j.4
        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            if (j.this.lGv != null) {
                j.this.lGv.bRj();
            }
        }
    };
    private a.InterfaceC0680a lwI = new a.InterfaceC0680a() { // from class: com.baidu.tieba.write.write.j.5
        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0680a
        public void onError() {
            j.this.eR(null);
        }

        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0680a
        public void c(List<SimpleForum> list, int i) {
            j.this.eR(list);
        }
    };
    private a.InterfaceC0018a eYm = new a.InterfaceC0018a() { // from class: com.baidu.tieba.write.write.j.6
        @Override // com.baidu.adp.lib.c.a.InterfaceC0018a
        public void onLocationGeted(int i, String str, Address address) {
            if (i == 0 && address != null) {
                j.this.mLat = String.valueOf(address.getLatitude());
                j.this.mLng = String.valueOf(address.getLongitude());
            }
        }
    };
    private final NewWriteModel.d dYH = new NewWriteModel.d() { // from class: com.baidu.tieba.write.write.j.7
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, aa aaVar, WriteData writeData, AntiData antiData) {
            j.this.lGt.closeLoadingDialog();
            if (postWriteCallBackData != null) {
                j.this.hSm.aW(null);
                j.this.hSm.uN(false);
                if (z) {
                    String errorString = postWriteCallBackData.getErrorString();
                    String preMsg = postWriteCallBackData.getPreMsg();
                    String colorMsg = postWriteCallBackData.getColorMsg();
                    if (j.this.e(writeData)) {
                        com.baidu.tieba.tbadkCore.writeModel.c.g(j.this.duG.getPageActivity(), errorString, preMsg, colorMsg);
                    }
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent.putExtras(bundle);
                    j.this.duG.getPageActivity().setResult(-1, intent);
                    j.this.duG.getPageActivity().finish();
                } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    j.this.duG.showToast(postWriteCallBackData.getErrorString());
                    j.this.hSm.aW(postWriteCallBackData.getSensitiveWords());
                    j.this.hSm.Mp(postWriteCallBackData.getErrorString());
                    if (!v.isEmpty(j.this.hSm.deS())) {
                        j.this.uY(true);
                    }
                } else if ((aaVar == null || writeData == null || aaVar.getVcode_pic_url() == null || AntiHelper.e(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                    j.this.lGt.l(postWriteCallBackData);
                } else if (aaVar != null && writeData != null && aaVar.getVcode_pic_url() != null) {
                    writeData.setVcodeMD5(aaVar.getVcode_md5());
                    writeData.setVcodeUrl(aaVar.getVcode_pic_url());
                    writeData.setVcodeExtra(aaVar.aSi());
                    if (!com.baidu.tbadk.s.a.xo(aaVar.aSh())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(j.this.duG.getPageActivity(), writeData, RequestResponseCode.REQUEST_VCODE)));
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(j.this.duG.getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, false, aaVar.aSh())));
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(j.this.duG.getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };

    public j(TbPageContext tbPageContext, k kVar, com.baidu.tieba.write.model.a aVar, WriteUrlModel writeUrlModel) {
        this.lGw = null;
        this.duG = tbPageContext;
        this.lGt = kVar;
        this.lGu = aVar;
        this.lGo = writeUrlModel;
        this.lGt.aj(this.mClickListener);
        this.lGt.ak(this.lGx);
        this.lGt.f(this.lGy);
        dhW();
        this.lGw = new com.baidu.tbadk.core.view.a(this.duG);
        this.lGw.setCancelListener(this.lGz);
        dhU();
        this.lGo.b(this.dYH);
        this.hSm = new com.baidu.tieba.write.c();
        this.hSm.EI(R.color.cp_cont_a);
        this.hSm.EJ(R.color.cp_cont_h_alpha85);
    }

    private void dhU() {
        this.lGv = new com.baidu.tieba.write.transmit.model.a(this.duG.getUniqueId());
        this.lGv.a(this.lwI);
        if (this.lGo.cSN() != null) {
            this.lGv.setForumId(this.lGo.cSN().getForumId());
        }
    }

    protected void dhV() {
        this.lGt.dii();
    }

    protected void dhW() {
        this.lGt.b((com.baidu.tieba.write.a.a) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eR(List<SimpleForum> list) {
        WriteData cSN = this.lGo.cSN();
        if (cSN != null) {
            this.lGw.setDialogVisiable(false);
            ArrayList<TransmitForumData> arrayList = new ArrayList<>();
            if (!StringUtils.isNull(cSN.getForumId()) && !cSN.getForumId().equals("0") && !StringUtils.isNull(cSN.getForumName())) {
                TransmitForumData transmitForumData = new TransmitForumData(com.baidu.adp.lib.f.b.toLong(cSN.getForumId(), 0L), cSN.getForumName(), true, 0);
                if (arrayList != null) {
                    arrayList.add(transmitForumData);
                }
            }
            if (v.getCount(list) > 0) {
                for (SimpleForum simpleForum : list) {
                    if (simpleForum != null && simpleForum.id != null && !StringUtils.isNull(simpleForum.name) && simpleForum.id.longValue() != com.baidu.adp.lib.f.b.toLong(cSN.getForumId(), 0L)) {
                        arrayList.add(new TransmitForumData(simpleForum.id.longValue(), simpleForum.name, false, 1));
                    }
                }
            }
            TransmitForumActivityConfig transmitForumActivityConfig = new TransmitForumActivityConfig(this.duG.getPageActivity(), RequestResponseCode.REQUEST_SELECT_TRANSMIT_FORUM);
            CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, transmitForumActivityConfig);
            transmitForumActivityConfig.setRecommendForumList(arrayList);
            MessageManager.getInstance().sendMessage(customMessage);
        }
    }

    public void cXa() {
        if (ab.checkLocationForBaiduLocation(this.duG.getPageActivity())) {
            com.baidu.adp.lib.c.a.ko().a(true, this.eYm);
        }
    }

    public void destroy() {
        if (this.lGv != null) {
            this.lGv.destroy();
        }
        if (this.lGu != null) {
            this.lGu.destroy();
        }
        if (this.lGo != null) {
            this.lGo.cancelLoadData();
        }
    }

    public void bFW() {
        this.lGv.setThreadContent(this.lGt.dic());
        this.lGv.loadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uY(boolean z) {
        if (this.lGt.die() != null && this.lGt.dic() != null) {
            int selectionEnd = this.lGt.die().getSelectionEnd();
            SpannableStringBuilder a = this.hSm.a(this.lGt.die().getText());
            if (a != null) {
                this.hSm.uO(true);
                this.lGt.die().setText(a);
                if (z && this.hSm.deT() >= 0) {
                    this.lGt.die().requestFocus();
                    this.lGt.die().setSelection(this.hSm.deT());
                } else {
                    this.lGt.die().setSelection(selectionEnd);
                }
                this.hSm.uN(this.hSm.deT() >= 0);
            }
        }
    }

    public boolean dhX() {
        if (this.hSm.deU()) {
            this.duG.showToast(this.hSm.deW());
            uY(true);
            return true;
        }
        return false;
    }

    public void onChangeSkinType() {
        this.hSm.onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean e(WriteData writeData) {
        return writeData == null || !("1".equals(writeData.getCallFrom()) || "2".equals(writeData.getCallFrom()));
    }

    public void a(BaseActivity baseActivity, int i, int i2, Intent intent) {
        PostWriteCallBackData postWriteCallBackData;
        WriteData cSN;
        if (i2 == -1) {
            if (i == 12006) {
                PostWriteCallBackData postWriteCallBackData2 = null;
                if (intent != null && intent.getExtras() != null && (intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData)) {
                    postWriteCallBackData2 = (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data");
                }
                if (postWriteCallBackData2 != null) {
                    Intent intent2 = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData2);
                    intent2.putExtras(bundle);
                    this.duG.getPageActivity().setResult(-1, intent2);
                }
                baseActivity.finish();
            } else if (i == 25013 && (cSN = this.lGo.cSN()) != null && this.lGu.dfK() != null) {
                if (intent != null) {
                    cSN.setTransmitForumData(intent.getStringExtra(TransmitForumActivityConfig.KEY_FORUM_LIST_SELECTED));
                }
                cSN.setForumId("0");
                cSN.setCanNoForum(true);
                cSN.setRecommendExt(this.lGv.getRecommendExt());
                if (!TextUtils.isEmpty(this.mLat) && !TextUtils.isEmpty(this.mLng)) {
                    dhY();
                } else if (ab.checkLocationForBaiduLocation(this.duG.getPageActivity())) {
                    com.baidu.adp.lib.c.a.ko().a(true, new a.InterfaceC0018a() { // from class: com.baidu.tieba.write.write.j.8
                        @Override // com.baidu.adp.lib.c.a.InterfaceC0018a
                        public void onLocationGeted(int i3, String str, Address address) {
                            if (i3 == 0 && address != null) {
                                j.this.mLat = String.valueOf(address.getLatitude());
                                j.this.mLng = String.valueOf(address.getLongitude());
                            }
                            j.this.dhY();
                        }
                    });
                }
                this.lGt.showLoadingDialog();
            }
        } else if (i2 == 0) {
            switch (i) {
                case RequestResponseCode.REQUEST_VCODE /* 12006 */:
                    if (intent != null && intent.getExtras() != null && (intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData) && (postWriteCallBackData = (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data")) != null && postWriteCallBackData.isSensitiveError()) {
                        this.duG.showToast(postWriteCallBackData.getErrorString());
                        this.hSm.aW(postWriteCallBackData.getSensitiveWords());
                        if (!v.isEmpty(this.hSm.deS())) {
                            uY(true);
                            return;
                        }
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public void dhY() {
        this.lGo.e("", this.lGt.dic(), this.lGu.dfK().linkUrl, this.lGu.dfK().linkUrlCode, this.mLat, this.mLng);
    }
}
