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
    private static final Pattern mWV = Pattern.compile("[ ]*http(s)?://([\\w-]+\\.)+[\\w-]+(/[\\w- ./?#%&=]*)?", 2);
    private TbPageContext efn;
    public com.baidu.tieba.write.c iTY;
    public String mLat;
    public String mLng;
    private WriteUrlModel mWR;
    private m mWW;
    private com.baidu.tieba.write.model.a mWX;
    private com.baidu.tieba.write.transmit.model.a mWY;
    private com.baidu.tbadk.core.view.a mWZ;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.l.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && view.getId() != 0) {
                if (view.getId() == R.id.icon_invoke_link) {
                    l.this.dIZ();
                    TiebaStatic.log(new aq("c12169"));
                }
                if (view.getId() == R.id.url_edit_back_view) {
                    l.this.dIY();
                }
            }
        }
    };
    private View.OnClickListener mXa = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.l.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && view.getId() == R.id.url_add) {
                TiebaStatic.log(new aq("c12163"));
                String dJm = l.this.mWW.dJm();
                if (l.mWV.matcher(dJm).matches()) {
                    l.this.dIY();
                    l.this.mWX.SE(dJm);
                    l.this.mWW.a(null, true);
                    return;
                }
                TiebaStatic.log(new aq("c12164"));
                l.this.mWW.dJn();
            }
        }
    };
    private TextWatcher mXb = new TextWatcher() { // from class: com.baidu.tieba.write.write.l.3
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            l.this.mWW.dJe();
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (l.this.iTY != null) {
                if (!l.this.iTY.dFx()) {
                    l.this.xl(false);
                }
                l.this.iTY.wY(false);
            }
        }
    };
    private DialogInterface.OnCancelListener mXc = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.l.4
        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            if (l.this.mWY != null) {
                l.this.mWY.coU();
            }
        }
    };
    private a.InterfaceC0835a mLN = new a.InterfaceC0835a() { // from class: com.baidu.tieba.write.write.l.5
        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0835a
        public void onError() {
            l.this.fG(null);
        }

        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0835a
        public void w(List<SimpleForum> list, int i) {
            l.this.fG(list);
        }
    };
    private a.InterfaceC0018a fMY = new a.InterfaceC0018a() { // from class: com.baidu.tieba.write.write.l.6
        @Override // com.baidu.adp.lib.c.a.InterfaceC0018a
        public void onLocationGeted(int i, String str, Address address) {
            if (i == 0 && address != null) {
                l.this.mLat = String.valueOf(address.getLatitude());
                l.this.mLng = String.valueOf(address.getLongitude());
            }
        }
    };
    private final NewWriteModel.d eMD = new NewWriteModel.d() { // from class: com.baidu.tieba.write.write.l.7
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ag agVar, WriteData writeData, AntiData antiData) {
            l.this.mWW.closeLoadingDialog();
            if (postWriteCallBackData != null) {
                l.this.iTY.bf(null);
                l.this.iTY.wX(false);
                if (z) {
                    String errorString = postWriteCallBackData.getErrorString();
                    String preMsg = postWriteCallBackData.getPreMsg();
                    String colorMsg = postWriteCallBackData.getColorMsg();
                    if (l.this.e(writeData)) {
                        com.baidu.tieba.tbadkCore.writeModel.c.g(l.this.efn.getPageActivity(), errorString, preMsg, colorMsg);
                    }
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent.putExtras(bundle);
                    l.this.efn.getPageActivity().setResult(-1, intent);
                    l.this.efn.getPageActivity().finish();
                } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    l.this.efn.showToast(postWriteCallBackData.getErrorString());
                    l.this.iTY.bf(postWriteCallBackData.getSensitiveWords());
                    l.this.iTY.Sw(postWriteCallBackData.getErrorString());
                    if (!y.isEmpty(l.this.iTY.dFu())) {
                        l.this.xl(true);
                    }
                } else if ((agVar == null || writeData == null || agVar.getVcode_pic_url() == null || AntiHelper.e(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                    l.this.mWW.m(postWriteCallBackData);
                } else if (agVar != null && writeData != null && agVar.getVcode_pic_url() != null) {
                    writeData.setVcodeMD5(agVar.getVcode_md5());
                    writeData.setVcodeUrl(agVar.getVcode_pic_url());
                    writeData.setVcodeExtra(agVar.bmZ());
                    if (!com.baidu.tbadk.t.a.CO(agVar.bmY())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(l.this.efn.getPageActivity(), writeData, RequestResponseCode.REQUEST_VCODE)));
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(l.this.efn.getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, false, agVar.bmY())));
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(l.this.efn.getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };

    public l(TbPageContext tbPageContext, m mVar, com.baidu.tieba.write.model.a aVar, WriteUrlModel writeUrlModel) {
        this.mWZ = null;
        this.efn = tbPageContext;
        this.mWW = mVar;
        this.mWX = aVar;
        this.mWR = writeUrlModel;
        this.mWW.am(this.mClickListener);
        this.mWW.an(this.mXa);
        this.mWW.e(this.mXb);
        dIZ();
        this.mWZ = new com.baidu.tbadk.core.view.a(this.efn);
        this.mWZ.setCancelListener(this.mXc);
        dIX();
        this.mWR.b(this.eMD);
        this.iTY = new com.baidu.tieba.write.c();
        this.iTY.Jr(R.color.cp_cont_a);
        this.iTY.Js(R.color.cp_cont_h_alpha85);
    }

    private void dIX() {
        this.mWY = new com.baidu.tieba.write.transmit.model.a(this.efn.getUniqueId());
        this.mWY.a(this.mLN);
        if (this.mWR.cKZ() != null) {
            this.mWY.setForumId(this.mWR.cKZ().getForumId());
        }
    }

    protected void dIY() {
        this.mWW.dJl();
    }

    protected void dIZ() {
        this.mWW.b((com.baidu.tieba.write.a.a) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fG(List<SimpleForum> list) {
        WriteData cKZ = this.mWR.cKZ();
        if (cKZ != null) {
            this.mWZ.setDialogVisiable(false);
            ArrayList<TransmitForumData> arrayList = new ArrayList<>();
            if (!StringUtils.isNull(cKZ.getForumId()) && !cKZ.getForumId().equals("0") && !StringUtils.isNull(cKZ.getForumName())) {
                TransmitForumData transmitForumData = new TransmitForumData(com.baidu.adp.lib.f.b.toLong(cKZ.getForumId(), 0L), cKZ.getForumName(), true, 0);
                if (arrayList != null) {
                    arrayList.add(transmitForumData);
                }
            }
            if (y.getCount(list) > 0) {
                for (SimpleForum simpleForum : list) {
                    if (simpleForum != null && simpleForum.id != null && !StringUtils.isNull(simpleForum.name) && simpleForum.id.longValue() != com.baidu.adp.lib.f.b.toLong(cKZ.getForumId(), 0L)) {
                        arrayList.add(new TransmitForumData(simpleForum.id.longValue(), simpleForum.name, false, 1));
                    }
                }
            }
            TransmitForumActivityConfig transmitForumActivityConfig = new TransmitForumActivityConfig(this.efn.getPageActivity(), RequestResponseCode.REQUEST_SELECT_TRANSMIT_FORUM);
            CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, transmitForumActivityConfig);
            transmitForumActivityConfig.setRecommendForumList(arrayList);
            MessageManager.getInstance().sendMessage(customMessage);
        }
    }

    public void dxl() {
        if (ae.checkLocationForBaiduLocation(this.efn.getPageActivity())) {
            com.baidu.adp.lib.c.a.mf().a(true, this.fMY);
        }
    }

    public void destroy() {
        if (this.mWY != null) {
            this.mWY.destroy();
        }
        if (this.mWX != null) {
            this.mWX.destroy();
        }
        if (this.mWR != null) {
            this.mWR.cancelLoadData();
        }
    }

    public void ccY() {
        this.mWY.setThreadContent(this.mWW.dJf());
        this.mWY.loadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xl(boolean z) {
        if (this.mWW.dJh() != null && this.mWW.dJf() != null) {
            int selectionEnd = this.mWW.dJh().getSelectionEnd();
            SpannableStringBuilder c = this.iTY.c(this.mWW.dJh().getText());
            if (c != null) {
                this.iTY.wY(true);
                this.mWW.dJh().setText(c);
                if (z && this.iTY.dFv() >= 0) {
                    this.mWW.dJh().requestFocus();
                    this.mWW.dJh().setSelection(this.iTY.dFv());
                } else {
                    this.mWW.dJh().setSelection(selectionEnd);
                }
                this.iTY.wX(this.iTY.dFv() >= 0);
            }
        }
    }

    public boolean dJa() {
        if (this.iTY.dFw()) {
            this.efn.showToast(this.iTY.dFy());
            xl(true);
            return true;
        }
        return false;
    }

    public void onChangeSkinType() {
        this.iTY.onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean e(WriteData writeData) {
        return writeData == null || !("1".equals(writeData.getCallFrom()) || "2".equals(writeData.getCallFrom()));
    }

    public void a(BaseActivity baseActivity, int i, int i2, Intent intent) {
        PostWriteCallBackData postWriteCallBackData;
        WriteData cKZ;
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
                    this.efn.getPageActivity().setResult(-1, intent2);
                }
                baseActivity.finish();
            } else if (i == 25013 && (cKZ = this.mWR.cKZ()) != null && this.mWX.dGo() != null) {
                if (intent != null) {
                    cKZ.setTransmitForumData(intent.getStringExtra(TransmitForumActivityConfig.KEY_FORUM_LIST_SELECTED));
                }
                cKZ.setForumId("0");
                cKZ.setCanNoForum(true);
                cKZ.setRecommendExt(this.mWY.getRecommendExt());
                if (!TextUtils.isEmpty(this.mLat) && !TextUtils.isEmpty(this.mLng)) {
                    dJb();
                } else if (ae.checkLocationForBaiduLocation(this.efn.getPageActivity())) {
                    com.baidu.adp.lib.c.a.mf().a(true, new a.InterfaceC0018a() { // from class: com.baidu.tieba.write.write.l.8
                        @Override // com.baidu.adp.lib.c.a.InterfaceC0018a
                        public void onLocationGeted(int i3, String str, Address address) {
                            if (i3 == 0 && address != null) {
                                l.this.mLat = String.valueOf(address.getLatitude());
                                l.this.mLng = String.valueOf(address.getLongitude());
                            }
                            l.this.dJb();
                        }
                    });
                }
                this.mWW.showLoadingDialog();
            }
        } else if (i2 == 0) {
            switch (i) {
                case RequestResponseCode.REQUEST_VCODE /* 12006 */:
                    if (intent != null && intent.getExtras() != null && (intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData) && (postWriteCallBackData = (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data")) != null && postWriteCallBackData.isSensitiveError()) {
                        this.efn.showToast(postWriteCallBackData.getErrorString());
                        this.iTY.bf(postWriteCallBackData.getSensitiveWords());
                        if (!y.isEmpty(this.iTY.dFu())) {
                            xl(true);
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

    public void dJb() {
        this.mWR.g("", this.mWW.dJf(), this.mWX.dGo().linkUrl, this.mWX.dGo().linkUrlCode, this.mLat, this.mLng);
    }
}
