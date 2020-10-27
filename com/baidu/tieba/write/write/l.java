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
import com.baidu.tbadk.core.util.ae;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.ah;
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
public class l {
    private static final Pattern nJi = Pattern.compile("[ ]*http(s)?://([\\w-]+\\.)+[\\w-]+(/[\\w- ./?#%&=]*)?", 2);
    private TbPageContext eCn;
    public com.baidu.tieba.write.c jEj;
    public String mLat;
    public String mLng;
    private WriteUrlModel nJe;
    private m nJj;
    private com.baidu.tieba.write.model.a nJk;
    private com.baidu.tieba.write.transmit.model.a nJl;
    private com.baidu.tbadk.core.view.a nJm;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.l.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && view.getId() != 0) {
                if (view.getId() == R.id.icon_invoke_link) {
                    l.this.dUa();
                    TiebaStatic.log(new aq("c12169"));
                }
                if (view.getId() == R.id.url_edit_back_view) {
                    l.this.dTZ();
                }
            }
        }
    };
    private View.OnClickListener nJn = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.l.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && view.getId() == R.id.url_add) {
                TiebaStatic.log(new aq("c12163"));
                String dUn = l.this.nJj.dUn();
                if (l.nJi.matcher(dUn).matches()) {
                    l.this.dTZ();
                    l.this.nJk.Ur(dUn);
                    l.this.nJj.a(null, true);
                    return;
                }
                TiebaStatic.log(new aq("c12164"));
                l.this.nJj.dUo();
            }
        }
    };
    private TextWatcher nJo = new TextWatcher() { // from class: com.baidu.tieba.write.write.l.3
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            l.this.nJj.dUf();
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (l.this.jEj != null) {
                if (!l.this.jEj.dQu()) {
                    l.this.yu(false);
                }
                l.this.jEj.yh(false);
            }
        }
    };
    private DialogInterface.OnCancelListener nJp = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.l.4
        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            if (l.this.nJl != null) {
                l.this.nJl.cyM();
            }
        }
    };
    private a.InterfaceC0865a nxZ = new a.InterfaceC0865a() { // from class: com.baidu.tieba.write.write.l.5
        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0865a
        public void onError() {
            l.this.ga(null);
        }

        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0865a
        public void t(List<SimpleForum> list, int i) {
            l.this.ga(list);
        }
    };
    private a.InterfaceC0020a gmM = new a.InterfaceC0020a() { // from class: com.baidu.tieba.write.write.l.6
        @Override // com.baidu.adp.lib.c.a.InterfaceC0020a
        public void onLocationGeted(int i, String str, Address address) {
            if (i == 0 && address != null) {
                l.this.mLat = String.valueOf(address.getLatitude());
                l.this.mLng = String.valueOf(address.getLongitude());
            }
        }
    };
    private final NewWriteModel.d fke = new NewWriteModel.d() { // from class: com.baidu.tieba.write.write.l.7
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
            l.this.nJj.closeLoadingDialog();
            if (postWriteCallBackData != null) {
                l.this.jEj.bk(null);
                l.this.jEj.yg(false);
                if (z) {
                    String errorString = postWriteCallBackData.getErrorString();
                    String preMsg = postWriteCallBackData.getPreMsg();
                    String colorMsg = postWriteCallBackData.getColorMsg();
                    if (l.this.g(writeData)) {
                        com.baidu.tieba.tbadkCore.writeModel.c.g(l.this.eCn.getPageActivity(), errorString, preMsg, colorMsg);
                    }
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent.putExtras(bundle);
                    l.this.eCn.getPageActivity().setResult(-1, intent);
                    l.this.eCn.getPageActivity().finish();
                } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    l.this.eCn.showToast(postWriteCallBackData.getErrorString());
                    l.this.jEj.bk(postWriteCallBackData.getSensitiveWords());
                    l.this.jEj.Uj(postWriteCallBackData.getErrorString());
                    if (!y.isEmpty(l.this.jEj.dQr())) {
                        l.this.yu(true);
                    }
                } else if ((ahVar == null || writeData == null || ahVar.getVcode_pic_url() == null || AntiHelper.e(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                    l.this.nJj.n(postWriteCallBackData);
                } else if (ahVar != null && writeData != null && ahVar.getVcode_pic_url() != null) {
                    writeData.setVcodeMD5(ahVar.getVcode_md5());
                    writeData.setVcodeUrl(ahVar.getVcode_pic_url());
                    writeData.setVcodeExtra(ahVar.bsw());
                    if (!com.baidu.tbadk.t.a.Eq(ahVar.bsv())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(l.this.eCn.getPageActivity(), writeData, RequestResponseCode.REQUEST_VCODE)));
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(l.this.eCn.getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, false, ahVar.bsv())));
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(l.this.eCn.getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };

    public l(TbPageContext tbPageContext, m mVar, com.baidu.tieba.write.model.a aVar, WriteUrlModel writeUrlModel) {
        this.nJm = null;
        this.eCn = tbPageContext;
        this.nJj = mVar;
        this.nJk = aVar;
        this.nJe = writeUrlModel;
        this.nJj.am(this.mClickListener);
        this.nJj.an(this.nJn);
        this.nJj.e(this.nJo);
        dUa();
        this.nJm = new com.baidu.tbadk.core.view.a(this.eCn);
        this.nJm.setCancelListener(this.nJp);
        dTY();
        this.nJe.b(this.fke);
        this.jEj = new com.baidu.tieba.write.c();
        this.jEj.KT(R.color.cp_cont_a);
        this.jEj.KU(R.color.cp_cont_h_alpha85);
    }

    private void dTY() {
        this.nJl = new com.baidu.tieba.write.transmit.model.a(this.eCn.getUniqueId());
        this.nJl.a(this.nxZ);
        if (this.nJe.cVv() != null) {
            this.nJl.setForumId(this.nJe.cVv().getForumId());
        }
    }

    protected void dTZ() {
        this.nJj.dUm();
    }

    protected void dUa() {
        this.nJj.b((com.baidu.tieba.write.a.a) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ga(List<SimpleForum> list) {
        WriteData cVv = this.nJe.cVv();
        if (cVv != null) {
            this.nJm.setDialogVisiable(false);
            ArrayList<TransmitForumData> arrayList = new ArrayList<>();
            if (!StringUtils.isNull(cVv.getForumId()) && !cVv.getForumId().equals("0") && !StringUtils.isNull(cVv.getForumName())) {
                TransmitForumData transmitForumData = new TransmitForumData(com.baidu.adp.lib.f.b.toLong(cVv.getForumId(), 0L), cVv.getForumName(), true, 0);
                if (arrayList != null) {
                    arrayList.add(transmitForumData);
                }
            }
            if (y.getCount(list) > 0) {
                for (SimpleForum simpleForum : list) {
                    if (simpleForum != null && simpleForum.id != null && !StringUtils.isNull(simpleForum.name) && simpleForum.id.longValue() != com.baidu.adp.lib.f.b.toLong(cVv.getForumId(), 0L)) {
                        arrayList.add(new TransmitForumData(simpleForum.id.longValue(), simpleForum.name, false, 1));
                    }
                }
            }
            TransmitForumActivityConfig transmitForumActivityConfig = new TransmitForumActivityConfig(this.eCn.getPageActivity(), RequestResponseCode.REQUEST_SELECT_TRANSMIT_FORUM);
            CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, transmitForumActivityConfig);
            transmitForumActivityConfig.setRecommendForumList(arrayList);
            MessageManager.getInstance().sendMessage(customMessage);
        }
    }

    public void dId() {
        if (ae.checkLocationForBaiduLocation(this.eCn.getPageActivity())) {
            com.baidu.adp.lib.c.a.mk().a(true, this.gmM);
        }
    }

    public void destroy() {
        if (this.nJl != null) {
            this.nJl.destroy();
        }
        if (this.nJk != null) {
            this.nJk.destroy();
        }
        if (this.nJe != null) {
            this.nJe.cancelLoadData();
        }
    }

    public void cmR() {
        this.nJl.setThreadContent(this.nJj.dUg());
        this.nJl.loadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yu(boolean z) {
        if (this.nJj.dUi() != null && this.nJj.dUg() != null) {
            int selectionEnd = this.nJj.dUi().getSelectionEnd();
            SpannableStringBuilder c = this.jEj.c(this.nJj.dUi().getText());
            if (c != null) {
                this.jEj.yh(true);
                this.nJj.dUi().setText(c);
                if (z && this.jEj.dQs() >= 0) {
                    this.nJj.dUi().requestFocus();
                    this.nJj.dUi().setSelection(this.jEj.dQs());
                } else {
                    this.nJj.dUi().setSelection(selectionEnd);
                }
                this.jEj.yg(this.jEj.dQs() >= 0);
            }
        }
    }

    public boolean dUb() {
        if (this.jEj.dQt()) {
            this.eCn.showToast(this.jEj.dQv());
            yu(true);
            return true;
        }
        return false;
    }

    public void onChangeSkinType() {
        this.jEj.onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean g(WriteData writeData) {
        return writeData == null || !("1".equals(writeData.getCallFrom()) || "2".equals(writeData.getCallFrom()));
    }

    public void a(BaseActivity baseActivity, int i, int i2, Intent intent) {
        PostWriteCallBackData postWriteCallBackData;
        WriteData cVv;
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
                    this.eCn.getPageActivity().setResult(-1, intent2);
                }
                baseActivity.finish();
            } else if (i == 25013 && (cVv = this.nJe.cVv()) != null && this.nJk.dRl() != null) {
                if (intent != null) {
                    cVv.setTransmitForumData(intent.getStringExtra(TransmitForumActivityConfig.KEY_FORUM_LIST_SELECTED));
                }
                cVv.setForumId("0");
                cVv.setCanNoForum(true);
                cVv.setRecommendExt(this.nJl.getRecommendExt());
                if (!TextUtils.isEmpty(this.mLat) && !TextUtils.isEmpty(this.mLng)) {
                    dUc();
                } else if (ae.checkLocationForBaiduLocation(this.eCn.getPageActivity())) {
                    com.baidu.adp.lib.c.a.mk().a(true, new a.InterfaceC0020a() { // from class: com.baidu.tieba.write.write.l.8
                        @Override // com.baidu.adp.lib.c.a.InterfaceC0020a
                        public void onLocationGeted(int i3, String str, Address address) {
                            if (i3 == 0 && address != null) {
                                l.this.mLat = String.valueOf(address.getLatitude());
                                l.this.mLng = String.valueOf(address.getLongitude());
                            }
                            l.this.dUc();
                        }
                    });
                }
                this.nJj.showLoadingDialog();
            }
        } else if (i2 == 0) {
            switch (i) {
                case RequestResponseCode.REQUEST_VCODE /* 12006 */:
                    if (intent != null && intent.getExtras() != null && (intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData) && (postWriteCallBackData = (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data")) != null && postWriteCallBackData.isSensitiveError()) {
                        this.eCn.showToast(postWriteCallBackData.getErrorString());
                        this.jEj.bk(postWriteCallBackData.getSensitiveWords());
                        if (!y.isEmpty(this.jEj.dQr())) {
                            yu(true);
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

    public void dUc() {
        this.nJe.h("", this.nJj.dUg(), this.nJk.dRl().linkUrl, this.nJk.dRl().linkUrlCode, this.mLat, this.mLng);
    }
}
