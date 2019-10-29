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
import com.baidu.adp.lib.d.a;
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
import com.baidu.tbadk.coreExtra.data.y;
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
/* loaded from: classes3.dex */
public class j {
    private static final Pattern jWs = Pattern.compile("[ ]*http(s)?://([\\w-]+\\.)+[\\w-]+(/[\\w- ./?#%&=]*)?", 2);
    private TbPageContext cfl;
    public com.baidu.tieba.write.b goB;
    private WriteUrlModel jWo;
    private k jWt;
    private com.baidu.tieba.write.model.a jWu;
    private com.baidu.tieba.write.transmit.model.a jWv;
    private com.baidu.tbadk.core.view.b jWw;
    public String mLat;
    public String mLng;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.j.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && view.getId() != 0) {
                if (view.getId() == R.id.icon_invoke_link) {
                    j.this.cAv();
                    TiebaStatic.log(new an("c12169"));
                }
                if (view.getId() == R.id.url_edit_back_view) {
                    j.this.cAu();
                }
            }
        }
    };
    private View.OnClickListener jWx = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.j.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && view.getId() == R.id.url_add) {
                TiebaStatic.log(new an("c12163"));
                String cAI = j.this.jWt.cAI();
                if (j.jWs.matcher(cAI).matches()) {
                    j.this.cAu();
                    j.this.jWu.FC(cAI);
                    j.this.jWt.a(null, true);
                    return;
                }
                TiebaStatic.log(new an("c12164"));
                j.this.jWt.cAJ();
            }
        }
    };
    private TextWatcher jWy = new TextWatcher() { // from class: com.baidu.tieba.write.write.j.3
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            j.this.jWt.cAA();
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (j.this.goB != null) {
                if (!j.this.goB.cxB()) {
                    j.this.rS(false);
                }
                j.this.goB.rL(false);
            }
        }
    };
    private DialogInterface.OnCancelListener jWz = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.j.4
        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            if (j.this.jWv != null) {
                j.this.jWv.bmv();
            }
        }
    };
    private a.InterfaceC0541a jMN = new a.InterfaceC0541a() { // from class: com.baidu.tieba.write.write.j.5
        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0541a
        public void onError() {
            j.this.eP(null);
        }

        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0541a
        public void d(List<SimpleForum> list, int i) {
            j.this.eP(list);
        }
    };
    private a.InterfaceC0015a dEB = new a.InterfaceC0015a() { // from class: com.baidu.tieba.write.write.j.6
        @Override // com.baidu.adp.lib.d.a.InterfaceC0015a
        public void onLocationGeted(int i, String str, Address address) {
            if (i == 0 && address != null) {
                j.this.mLat = String.valueOf(address.getLatitude());
                j.this.mLng = String.valueOf(address.getLongitude());
            }
        }
    };
    private final NewWriteModel.d cHf = new NewWriteModel.d() { // from class: com.baidu.tieba.write.write.j.7
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, y yVar, WriteData writeData, AntiData antiData) {
            j.this.jWt.closeLoadingDialog();
            if (postWriteCallBackData != null) {
                j.this.goB.aM(null);
                j.this.goB.rK(false);
                if (z) {
                    String errorString = postWriteCallBackData.getErrorString();
                    String preMsg = postWriteCallBackData.getPreMsg();
                    String colorMsg = postWriteCallBackData.getColorMsg();
                    if (j.this.e(writeData)) {
                        com.baidu.tieba.tbadkCore.writeModel.c.g(j.this.cfl.getPageActivity(), errorString, preMsg, colorMsg);
                    }
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent.putExtras(bundle);
                    j.this.cfl.getPageActivity().setResult(-1, intent);
                    j.this.cfl.getPageActivity().finish();
                } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    j.this.cfl.showToast(postWriteCallBackData.getErrorString());
                    j.this.goB.aM(postWriteCallBackData.getSensitiveWords());
                    j.this.goB.Fv(postWriteCallBackData.getErrorString());
                    if (!v.isEmpty(j.this.goB.cxy())) {
                        j.this.rS(true);
                    }
                } else if ((yVar == null || writeData == null || yVar.getVcode_pic_url() == null || AntiHelper.e(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                    j.this.jWt.l(postWriteCallBackData);
                } else if (yVar != null && writeData != null && yVar.getVcode_pic_url() != null) {
                    writeData.setVcodeMD5(yVar.getVcode_md5());
                    writeData.setVcodeUrl(yVar.getVcode_pic_url());
                    writeData.setVcodeExtra(yVar.apu());
                    if (!com.baidu.tbadk.v.a.qv(yVar.apt())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(j.this.cfl.getPageActivity(), writeData, RequestResponseCode.REQUEST_VCODE)));
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(j.this.cfl.getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, false, yVar.apt())));
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(j.this.cfl.getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };

    public j(TbPageContext tbPageContext, k kVar, com.baidu.tieba.write.model.a aVar, WriteUrlModel writeUrlModel) {
        this.jWw = null;
        this.cfl = tbPageContext;
        this.jWt = kVar;
        this.jWu = aVar;
        this.jWo = writeUrlModel;
        this.jWt.af(this.mClickListener);
        this.jWt.ag(this.jWx);
        this.jWt.g(this.jWy);
        cAv();
        this.jWw = new com.baidu.tbadk.core.view.b(this.cfl);
        this.jWw.setCancelListener(this.jWz);
        cAt();
        this.jWo.b(this.cHf);
        this.goB = new com.baidu.tieba.write.b();
        this.goB.Bs(R.color.cp_cont_a);
        this.goB.Bt(R.color.cp_cont_h_alpha85);
    }

    private void cAt() {
        this.jWv = new com.baidu.tieba.write.transmit.model.a(this.cfl.getUniqueId());
        this.jWv.a(this.jMN);
        if (this.jWo.clc() != null) {
            this.jWv.setForumId(this.jWo.clc().getForumId());
        }
    }

    protected void cAu() {
        this.jWt.cAH();
    }

    protected void cAv() {
        this.jWt.b((com.baidu.tieba.write.a.a) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eP(List<SimpleForum> list) {
        WriteData clc = this.jWo.clc();
        if (clc != null) {
            this.jWw.setDialogVisiable(false);
            ArrayList<TransmitForumData> arrayList = new ArrayList<>();
            if (!StringUtils.isNull(clc.getForumId()) && !clc.getForumId().equals("0") && !StringUtils.isNull(clc.getForumName())) {
                TransmitForumData transmitForumData = new TransmitForumData(com.baidu.adp.lib.g.b.toLong(clc.getForumId(), 0L), clc.getForumName(), true, 0);
                if (arrayList != null) {
                    arrayList.add(transmitForumData);
                }
            }
            if (v.getCount(list) > 0) {
                for (SimpleForum simpleForum : list) {
                    if (simpleForum != null && simpleForum.id != null && !StringUtils.isNull(simpleForum.name) && simpleForum.id.longValue() != com.baidu.adp.lib.g.b.toLong(clc.getForumId(), 0L)) {
                        arrayList.add(new TransmitForumData(simpleForum.id.longValue(), simpleForum.name, false, 1));
                    }
                }
            }
            TransmitForumActivityConfig transmitForumActivityConfig = new TransmitForumActivityConfig(this.cfl.getPageActivity(), RequestResponseCode.REQUEST_SELECT_TRANSMIT_FORUM);
            CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, transmitForumActivityConfig);
            transmitForumActivityConfig.setRecommendForumList(arrayList);
            MessageManager.getInstance().sendMessage(customMessage);
        }
    }

    public void coZ() {
        if (ab.checkLocationForBaiduLocation(this.cfl.getPageActivity())) {
            com.baidu.adp.lib.d.a.fw().a(true, this.dEB);
        }
    }

    public void destroy() {
        if (this.jWv != null) {
            this.jWv.destroy();
        }
        if (this.jWu != null) {
            this.jWu.destroy();
        }
        if (this.jWo != null) {
            this.jWo.cancelLoadData();
        }
    }

    public void bcc() {
        this.jWv.setThreadContent(this.jWt.cAB());
        this.jWv.loadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rS(boolean z) {
        if (this.jWt.cAD() != null && this.jWt.cAB() != null) {
            int selectionEnd = this.jWt.cAD().getSelectionEnd();
            SpannableStringBuilder a = this.goB.a(this.jWt.cAD().getText());
            if (a != null) {
                this.goB.rL(true);
                this.jWt.cAD().setText(a);
                if (z && this.goB.cxz() >= 0) {
                    this.jWt.cAD().requestFocus();
                    this.jWt.cAD().setSelection(this.goB.cxz());
                } else {
                    this.jWt.cAD().setSelection(selectionEnd);
                }
                this.goB.rK(this.goB.cxz() >= 0);
            }
        }
    }

    public boolean cAw() {
        if (this.goB.cxA()) {
            this.cfl.showToast(this.goB.cxC());
            rS(true);
            return true;
        }
        return false;
    }

    public void onChangeSkinType() {
        this.goB.onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean e(WriteData writeData) {
        return writeData == null || !("1".equals(writeData.getCallFrom()) || "2".equals(writeData.getCallFrom()));
    }

    public void a(BaseActivity baseActivity, int i, int i2, Intent intent) {
        PostWriteCallBackData postWriteCallBackData;
        WriteData clc;
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
                    this.cfl.getPageActivity().setResult(-1, intent2);
                }
                baseActivity.finish();
            } else if (i == 25013 && (clc = this.jWo.clc()) != null && this.jWu.cyx() != null) {
                if (intent != null) {
                    clc.setTransmitForumData(intent.getStringExtra(TransmitForumActivityConfig.KEY_FORUM_LIST_SELECTED));
                }
                clc.setForumId("0");
                clc.setCanNoForum(true);
                clc.setRecommendExt(this.jWv.getRecommendExt());
                if (!TextUtils.isEmpty(this.mLat) && !TextUtils.isEmpty(this.mLng)) {
                    cAx();
                } else if (ab.checkLocationForBaiduLocation(this.cfl.getPageActivity())) {
                    com.baidu.adp.lib.d.a.fw().a(true, new a.InterfaceC0015a() { // from class: com.baidu.tieba.write.write.j.8
                        @Override // com.baidu.adp.lib.d.a.InterfaceC0015a
                        public void onLocationGeted(int i3, String str, Address address) {
                            if (i3 == 0 && address != null) {
                                j.this.mLat = String.valueOf(address.getLatitude());
                                j.this.mLng = String.valueOf(address.getLongitude());
                            }
                            j.this.cAx();
                        }
                    });
                }
                this.jWt.showLoadingDialog();
            }
        } else if (i2 == 0) {
            switch (i) {
                case RequestResponseCode.REQUEST_VCODE /* 12006 */:
                    if (intent != null && intent.getExtras() != null && (intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData) && (postWriteCallBackData = (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data")) != null && postWriteCallBackData.isSensitiveError()) {
                        this.cfl.showToast(postWriteCallBackData.getErrorString());
                        this.goB.aM(postWriteCallBackData.getSensitiveWords());
                        if (!v.isEmpty(this.goB.cxy())) {
                            rS(true);
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

    public void cAx() {
        this.jWo.e("", this.jWt.cAB(), this.jWu.cyx().linkUrl, this.jWu.cyx().linkUrlCode, this.mLat, this.mLng);
    }
}
