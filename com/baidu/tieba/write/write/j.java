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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.ab;
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
    private static final Pattern maY = Pattern.compile("[ ]*http(s)?://([\\w-]+\\.)+[\\w-]+(/[\\w- ./?#%&=]*)?", 2);
    private TbPageContext dIF;
    public com.baidu.tieba.write.c ihP;
    public String mLat;
    public String mLng;
    private WriteUrlModel maU;
    private k maZ;
    private com.baidu.tieba.write.model.a mba;
    private com.baidu.tieba.write.transmit.model.a mbb;
    private com.baidu.tbadk.core.view.a mbc;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.j.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && view.getId() != 0) {
                if (view.getId() == R.id.icon_invoke_link) {
                    j.this.dpz();
                    TiebaStatic.log(new an("c12169"));
                }
                if (view.getId() == R.id.url_edit_back_view) {
                    j.this.dpy();
                }
            }
        }
    };
    private View.OnClickListener mbd = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.j.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && view.getId() == R.id.url_add) {
                TiebaStatic.log(new an("c12163"));
                String dpM = j.this.maZ.dpM();
                if (j.maY.matcher(dpM).matches()) {
                    j.this.dpy();
                    j.this.mba.On(dpM);
                    j.this.maZ.a(null, true);
                    return;
                }
                TiebaStatic.log(new an("c12164"));
                j.this.maZ.dpN();
            }
        }
    };
    private TextWatcher mbe = new TextWatcher() { // from class: com.baidu.tieba.write.write.j.3
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            j.this.maZ.dpE();
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (j.this.ihP != null) {
                if (!j.this.ihP.dmy()) {
                    j.this.vy(false);
                }
                j.this.ihP.vn(false);
            }
        }
    };
    private DialogInterface.OnCancelListener mbf = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.j.4
        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            if (j.this.mbb != null) {
                j.this.mbb.bXG();
            }
        }
    };
    private a.InterfaceC0755a lRl = new a.InterfaceC0755a() { // from class: com.baidu.tieba.write.write.j.5
        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0755a
        public void onError() {
            j.this.fa(null);
        }

        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0755a
        public void g(List<SimpleForum> list, int i) {
            j.this.fa(list);
        }
    };
    private a.InterfaceC0020a flm = new a.InterfaceC0020a() { // from class: com.baidu.tieba.write.write.j.6
        @Override // com.baidu.adp.lib.c.a.InterfaceC0020a
        public void onLocationGeted(int i, String str, Address address) {
            if (i == 0 && address != null) {
                j.this.mLat = String.valueOf(address.getLatitude());
                j.this.mLng = String.valueOf(address.getLongitude());
            }
        }
    };
    private final NewWriteModel.d emV = new NewWriteModel.d() { // from class: com.baidu.tieba.write.write.j.7
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ab abVar, WriteData writeData, AntiData antiData) {
            j.this.maZ.closeLoadingDialog();
            if (postWriteCallBackData != null) {
                j.this.ihP.aX(null);
                j.this.ihP.vm(false);
                if (z) {
                    String errorString = postWriteCallBackData.getErrorString();
                    String preMsg = postWriteCallBackData.getPreMsg();
                    String colorMsg = postWriteCallBackData.getColorMsg();
                    if (j.this.e(writeData)) {
                        com.baidu.tieba.tbadkCore.writeModel.c.f(j.this.dIF.getPageActivity(), errorString, preMsg, colorMsg);
                    }
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent.putExtras(bundle);
                    j.this.dIF.getPageActivity().setResult(-1, intent);
                    j.this.dIF.getPageActivity().finish();
                } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    j.this.dIF.showToast(postWriteCallBackData.getErrorString());
                    j.this.ihP.aX(postWriteCallBackData.getSensitiveWords());
                    j.this.ihP.Og(postWriteCallBackData.getErrorString());
                    if (!v.isEmpty(j.this.ihP.dmv())) {
                        j.this.vy(true);
                    }
                } else if ((abVar == null || writeData == null || abVar.getVcode_pic_url() == null || AntiHelper.e(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                    j.this.maZ.l(postWriteCallBackData);
                } else if (abVar != null && writeData != null && abVar.getVcode_pic_url() != null) {
                    writeData.setVcodeMD5(abVar.getVcode_md5());
                    writeData.setVcodeUrl(abVar.getVcode_pic_url());
                    writeData.setVcodeExtra(abVar.aYn());
                    if (!com.baidu.tbadk.s.a.yX(abVar.aYm())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(j.this.dIF.getPageActivity(), writeData, RequestResponseCode.REQUEST_VCODE)));
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(j.this.dIF.getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, false, abVar.aYm())));
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(j.this.dIF.getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };

    public j(TbPageContext tbPageContext, k kVar, com.baidu.tieba.write.model.a aVar, WriteUrlModel writeUrlModel) {
        this.mbc = null;
        this.dIF = tbPageContext;
        this.maZ = kVar;
        this.mba = aVar;
        this.maU = writeUrlModel;
        this.maZ.aj(this.mClickListener);
        this.maZ.ak(this.mbd);
        this.maZ.e(this.mbe);
        dpz();
        this.mbc = new com.baidu.tbadk.core.view.a(this.dIF);
        this.mbc.setCancelListener(this.mbf);
        dpx();
        this.maU.b(this.emV);
        this.ihP = new com.baidu.tieba.write.c();
        this.ihP.Fv(R.color.cp_cont_a);
        this.ihP.Fw(R.color.cp_cont_h_alpha85);
    }

    private void dpx() {
        this.mbb = new com.baidu.tieba.write.transmit.model.a(this.dIF.getUniqueId());
        this.mbb.a(this.lRl);
        if (this.maU.daf() != null) {
            this.mbb.setForumId(this.maU.daf().getForumId());
        }
    }

    protected void dpy() {
        this.maZ.dpL();
    }

    protected void dpz() {
        this.maZ.b((com.baidu.tieba.write.a.a) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fa(List<SimpleForum> list) {
        WriteData daf = this.maU.daf();
        if (daf != null) {
            this.mbc.setDialogVisiable(false);
            ArrayList<TransmitForumData> arrayList = new ArrayList<>();
            if (!StringUtils.isNull(daf.getForumId()) && !daf.getForumId().equals("0") && !StringUtils.isNull(daf.getForumName())) {
                TransmitForumData transmitForumData = new TransmitForumData(com.baidu.adp.lib.f.b.toLong(daf.getForumId(), 0L), daf.getForumName(), true, 0);
                if (arrayList != null) {
                    arrayList.add(transmitForumData);
                }
            }
            if (v.getCount(list) > 0) {
                for (SimpleForum simpleForum : list) {
                    if (simpleForum != null && simpleForum.id != null && !StringUtils.isNull(simpleForum.name) && simpleForum.id.longValue() != com.baidu.adp.lib.f.b.toLong(daf.getForumId(), 0L)) {
                        arrayList.add(new TransmitForumData(simpleForum.id.longValue(), simpleForum.name, false, 1));
                    }
                }
            }
            TransmitForumActivityConfig transmitForumActivityConfig = new TransmitForumActivityConfig(this.dIF.getPageActivity(), RequestResponseCode.REQUEST_SELECT_TRANSMIT_FORUM);
            CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, transmitForumActivityConfig);
            transmitForumActivityConfig.setRecommendForumList(arrayList);
            MessageManager.getInstance().sendMessage(customMessage);
        }
    }

    public void deu() {
        if (com.baidu.tbadk.core.util.ab.checkLocationForBaiduLocation(this.dIF.getPageActivity())) {
            com.baidu.adp.lib.c.a.kq().a(true, this.flm);
        }
    }

    public void destroy() {
        if (this.mbb != null) {
            this.mbb.destroy();
        }
        if (this.mba != null) {
            this.mba.destroy();
        }
        if (this.maU != null) {
            this.maU.cancelLoadData();
        }
    }

    public void bMq() {
        this.mbb.setThreadContent(this.maZ.dpF());
        this.mbb.loadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vy(boolean z) {
        if (this.maZ.dpH() != null && this.maZ.dpF() != null) {
            int selectionEnd = this.maZ.dpH().getSelectionEnd();
            SpannableStringBuilder a = this.ihP.a(this.maZ.dpH().getText());
            if (a != null) {
                this.ihP.vn(true);
                this.maZ.dpH().setText(a);
                if (z && this.ihP.dmw() >= 0) {
                    this.maZ.dpH().requestFocus();
                    this.maZ.dpH().setSelection(this.ihP.dmw());
                } else {
                    this.maZ.dpH().setSelection(selectionEnd);
                }
                this.ihP.vm(this.ihP.dmw() >= 0);
            }
        }
    }

    public boolean dpA() {
        if (this.ihP.dmx()) {
            this.dIF.showToast(this.ihP.dmz());
            vy(true);
            return true;
        }
        return false;
    }

    public void onChangeSkinType() {
        this.ihP.onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean e(WriteData writeData) {
        return writeData == null || !("1".equals(writeData.getCallFrom()) || "2".equals(writeData.getCallFrom()));
    }

    public void a(BaseActivity baseActivity, int i, int i2, Intent intent) {
        PostWriteCallBackData postWriteCallBackData;
        WriteData daf;
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
                    this.dIF.getPageActivity().setResult(-1, intent2);
                }
                baseActivity.finish();
            } else if (i == 25013 && (daf = this.maU.daf()) != null && this.mba.dno() != null) {
                if (intent != null) {
                    daf.setTransmitForumData(intent.getStringExtra(TransmitForumActivityConfig.KEY_FORUM_LIST_SELECTED));
                }
                daf.setForumId("0");
                daf.setCanNoForum(true);
                daf.setRecommendExt(this.mbb.getRecommendExt());
                if (!TextUtils.isEmpty(this.mLat) && !TextUtils.isEmpty(this.mLng)) {
                    dpB();
                } else if (com.baidu.tbadk.core.util.ab.checkLocationForBaiduLocation(this.dIF.getPageActivity())) {
                    com.baidu.adp.lib.c.a.kq().a(true, new a.InterfaceC0020a() { // from class: com.baidu.tieba.write.write.j.8
                        @Override // com.baidu.adp.lib.c.a.InterfaceC0020a
                        public void onLocationGeted(int i3, String str, Address address) {
                            if (i3 == 0 && address != null) {
                                j.this.mLat = String.valueOf(address.getLatitude());
                                j.this.mLng = String.valueOf(address.getLongitude());
                            }
                            j.this.dpB();
                        }
                    });
                }
                this.maZ.showLoadingDialog();
            }
        } else if (i2 == 0) {
            switch (i) {
                case RequestResponseCode.REQUEST_VCODE /* 12006 */:
                    if (intent != null && intent.getExtras() != null && (intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData) && (postWriteCallBackData = (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data")) != null && postWriteCallBackData.isSensitiveError()) {
                        this.dIF.showToast(postWriteCallBackData.getErrorString());
                        this.ihP.aX(postWriteCallBackData.getSensitiveWords());
                        if (!v.isEmpty(this.ihP.dmv())) {
                            vy(true);
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

    public void dpB() {
        this.maU.e("", this.maZ.dpF(), this.mba.dno().linkUrl, this.mba.dno().linkUrlCode, this.mLat, this.mLng);
    }
}
