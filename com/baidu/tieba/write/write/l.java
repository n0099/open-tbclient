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
import com.baidu.tbadk.coreExtra.data.ag;
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
    private static final Pattern mXn = Pattern.compile("[ ]*http(s)?://([\\w-]+\\.)+[\\w-]+(/[\\w- ./?#%&=]*)?", 2);
    private TbPageContext efr;
    public com.baidu.tieba.write.c iUe;
    public String mLat;
    public String mLng;
    private WriteUrlModel mXj;
    private m mXo;
    private com.baidu.tieba.write.model.a mXp;
    private com.baidu.tieba.write.transmit.model.a mXq;
    private com.baidu.tbadk.core.view.a mXr;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.l.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && view.getId() != 0) {
                if (view.getId() == R.id.icon_invoke_link) {
                    l.this.dJi();
                    TiebaStatic.log(new aq("c12169"));
                }
                if (view.getId() == R.id.url_edit_back_view) {
                    l.this.dJh();
                }
            }
        }
    };
    private View.OnClickListener mXs = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.l.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && view.getId() == R.id.url_add) {
                TiebaStatic.log(new aq("c12163"));
                String dJv = l.this.mXo.dJv();
                if (l.mXn.matcher(dJv).matches()) {
                    l.this.dJh();
                    l.this.mXp.SE(dJv);
                    l.this.mXo.a(null, true);
                    return;
                }
                TiebaStatic.log(new aq("c12164"));
                l.this.mXo.dJw();
            }
        }
    };
    private TextWatcher mXt = new TextWatcher() { // from class: com.baidu.tieba.write.write.l.3
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            l.this.mXo.dJn();
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (l.this.iUe != null) {
                if (!l.this.iUe.dFG()) {
                    l.this.xn(false);
                }
                l.this.iUe.xa(false);
            }
        }
    };
    private DialogInterface.OnCancelListener mXu = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.l.4
        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            if (l.this.mXq != null) {
                l.this.mXq.coV();
            }
        }
    };
    private a.InterfaceC0835a mMf = new a.InterfaceC0835a() { // from class: com.baidu.tieba.write.write.l.5
        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0835a
        public void onError() {
            l.this.fG(null);
        }

        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0835a
        public void w(List<SimpleForum> list, int i) {
            l.this.fG(list);
        }
    };
    private a.InterfaceC0018a fNc = new a.InterfaceC0018a() { // from class: com.baidu.tieba.write.write.l.6
        @Override // com.baidu.adp.lib.c.a.InterfaceC0018a
        public void onLocationGeted(int i, String str, Address address) {
            if (i == 0 && address != null) {
                l.this.mLat = String.valueOf(address.getLatitude());
                l.this.mLng = String.valueOf(address.getLongitude());
            }
        }
    };
    private final NewWriteModel.d eMH = new NewWriteModel.d() { // from class: com.baidu.tieba.write.write.l.7
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ag agVar, WriteData writeData, AntiData antiData) {
            l.this.mXo.closeLoadingDialog();
            if (postWriteCallBackData != null) {
                l.this.iUe.bf(null);
                l.this.iUe.wZ(false);
                if (z) {
                    String errorString = postWriteCallBackData.getErrorString();
                    String preMsg = postWriteCallBackData.getPreMsg();
                    String colorMsg = postWriteCallBackData.getColorMsg();
                    if (l.this.e(writeData)) {
                        com.baidu.tieba.tbadkCore.writeModel.c.g(l.this.efr.getPageActivity(), errorString, preMsg, colorMsg);
                    }
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent.putExtras(bundle);
                    l.this.efr.getPageActivity().setResult(-1, intent);
                    l.this.efr.getPageActivity().finish();
                } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    l.this.efr.showToast(postWriteCallBackData.getErrorString());
                    l.this.iUe.bf(postWriteCallBackData.getSensitiveWords());
                    l.this.iUe.Sw(postWriteCallBackData.getErrorString());
                    if (!y.isEmpty(l.this.iUe.dFD())) {
                        l.this.xn(true);
                    }
                } else if ((agVar == null || writeData == null || agVar.getVcode_pic_url() == null || AntiHelper.e(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                    l.this.mXo.m(postWriteCallBackData);
                } else if (agVar != null && writeData != null && agVar.getVcode_pic_url() != null) {
                    writeData.setVcodeMD5(agVar.getVcode_md5());
                    writeData.setVcodeUrl(agVar.getVcode_pic_url());
                    writeData.setVcodeExtra(agVar.bmZ());
                    if (!com.baidu.tbadk.t.a.CP(agVar.bmY())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(l.this.efr.getPageActivity(), writeData, RequestResponseCode.REQUEST_VCODE)));
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(l.this.efr.getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, false, agVar.bmY())));
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(l.this.efr.getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };

    public l(TbPageContext tbPageContext, m mVar, com.baidu.tieba.write.model.a aVar, WriteUrlModel writeUrlModel) {
        this.mXr = null;
        this.efr = tbPageContext;
        this.mXo = mVar;
        this.mXp = aVar;
        this.mXj = writeUrlModel;
        this.mXo.am(this.mClickListener);
        this.mXo.an(this.mXs);
        this.mXo.e(this.mXt);
        dJi();
        this.mXr = new com.baidu.tbadk.core.view.a(this.efr);
        this.mXr.setCancelListener(this.mXu);
        dJg();
        this.mXj.b(this.eMH);
        this.iUe = new com.baidu.tieba.write.c();
        this.iUe.Jr(R.color.cp_cont_a);
        this.iUe.Js(R.color.cp_cont_h_alpha85);
    }

    private void dJg() {
        this.mXq = new com.baidu.tieba.write.transmit.model.a(this.efr.getUniqueId());
        this.mXq.a(this.mMf);
        if (this.mXj.cLa() != null) {
            this.mXq.setForumId(this.mXj.cLa().getForumId());
        }
    }

    protected void dJh() {
        this.mXo.dJu();
    }

    protected void dJi() {
        this.mXo.b((com.baidu.tieba.write.a.a) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fG(List<SimpleForum> list) {
        WriteData cLa = this.mXj.cLa();
        if (cLa != null) {
            this.mXr.setDialogVisiable(false);
            ArrayList<TransmitForumData> arrayList = new ArrayList<>();
            if (!StringUtils.isNull(cLa.getForumId()) && !cLa.getForumId().equals("0") && !StringUtils.isNull(cLa.getForumName())) {
                TransmitForumData transmitForumData = new TransmitForumData(com.baidu.adp.lib.f.b.toLong(cLa.getForumId(), 0L), cLa.getForumName(), true, 0);
                if (arrayList != null) {
                    arrayList.add(transmitForumData);
                }
            }
            if (y.getCount(list) > 0) {
                for (SimpleForum simpleForum : list) {
                    if (simpleForum != null && simpleForum.id != null && !StringUtils.isNull(simpleForum.name) && simpleForum.id.longValue() != com.baidu.adp.lib.f.b.toLong(cLa.getForumId(), 0L)) {
                        arrayList.add(new TransmitForumData(simpleForum.id.longValue(), simpleForum.name, false, 1));
                    }
                }
            }
            TransmitForumActivityConfig transmitForumActivityConfig = new TransmitForumActivityConfig(this.efr.getPageActivity(), RequestResponseCode.REQUEST_SELECT_TRANSMIT_FORUM);
            CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, transmitForumActivityConfig);
            transmitForumActivityConfig.setRecommendForumList(arrayList);
            MessageManager.getInstance().sendMessage(customMessage);
        }
    }

    public void dxq() {
        if (ae.checkLocationForBaiduLocation(this.efr.getPageActivity())) {
            com.baidu.adp.lib.c.a.mf().a(true, this.fNc);
        }
    }

    public void destroy() {
        if (this.mXq != null) {
            this.mXq.destroy();
        }
        if (this.mXp != null) {
            this.mXp.destroy();
        }
        if (this.mXj != null) {
            this.mXj.cancelLoadData();
        }
    }

    public void ccZ() {
        this.mXq.setThreadContent(this.mXo.dJo());
        this.mXq.loadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xn(boolean z) {
        if (this.mXo.dJq() != null && this.mXo.dJo() != null) {
            int selectionEnd = this.mXo.dJq().getSelectionEnd();
            SpannableStringBuilder c = this.iUe.c(this.mXo.dJq().getText());
            if (c != null) {
                this.iUe.xa(true);
                this.mXo.dJq().setText(c);
                if (z && this.iUe.dFE() >= 0) {
                    this.mXo.dJq().requestFocus();
                    this.mXo.dJq().setSelection(this.iUe.dFE());
                } else {
                    this.mXo.dJq().setSelection(selectionEnd);
                }
                this.iUe.wZ(this.iUe.dFE() >= 0);
            }
        }
    }

    public boolean dJj() {
        if (this.iUe.dFF()) {
            this.efr.showToast(this.iUe.dFH());
            xn(true);
            return true;
        }
        return false;
    }

    public void onChangeSkinType() {
        this.iUe.onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean e(WriteData writeData) {
        return writeData == null || !("1".equals(writeData.getCallFrom()) || "2".equals(writeData.getCallFrom()));
    }

    public void a(BaseActivity baseActivity, int i, int i2, Intent intent) {
        PostWriteCallBackData postWriteCallBackData;
        WriteData cLa;
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
                    this.efr.getPageActivity().setResult(-1, intent2);
                }
                baseActivity.finish();
            } else if (i == 25013 && (cLa = this.mXj.cLa()) != null && this.mXp.dGx() != null) {
                if (intent != null) {
                    cLa.setTransmitForumData(intent.getStringExtra(TransmitForumActivityConfig.KEY_FORUM_LIST_SELECTED));
                }
                cLa.setForumId("0");
                cLa.setCanNoForum(true);
                cLa.setRecommendExt(this.mXq.getRecommendExt());
                if (!TextUtils.isEmpty(this.mLat) && !TextUtils.isEmpty(this.mLng)) {
                    dJk();
                } else if (ae.checkLocationForBaiduLocation(this.efr.getPageActivity())) {
                    com.baidu.adp.lib.c.a.mf().a(true, new a.InterfaceC0018a() { // from class: com.baidu.tieba.write.write.l.8
                        @Override // com.baidu.adp.lib.c.a.InterfaceC0018a
                        public void onLocationGeted(int i3, String str, Address address) {
                            if (i3 == 0 && address != null) {
                                l.this.mLat = String.valueOf(address.getLatitude());
                                l.this.mLng = String.valueOf(address.getLongitude());
                            }
                            l.this.dJk();
                        }
                    });
                }
                this.mXo.showLoadingDialog();
            }
        } else if (i2 == 0) {
            switch (i) {
                case RequestResponseCode.REQUEST_VCODE /* 12006 */:
                    if (intent != null && intent.getExtras() != null && (intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData) && (postWriteCallBackData = (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data")) != null && postWriteCallBackData.isSensitiveError()) {
                        this.efr.showToast(postWriteCallBackData.getErrorString());
                        this.iUe.bf(postWriteCallBackData.getSensitiveWords());
                        if (!y.isEmpty(this.iUe.dFD())) {
                            xn(true);
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

    public void dJk() {
        this.mXj.g("", this.mXo.dJo(), this.mXp.dGx().linkUrl, this.mXp.dGx().linkUrlCode, this.mLat, this.mLng);
    }
}
