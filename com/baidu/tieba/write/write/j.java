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
/* loaded from: classes10.dex */
public class j {
    private static final Pattern kQo = Pattern.compile("[ ]*http(s)?://([\\w-]+\\.)+[\\w-]+(/[\\w- ./?#%&=]*)?", 2);
    private TbPageContext cQU;
    public com.baidu.tieba.write.c hbl;
    private WriteUrlModel kQk;
    private k kQp;
    private com.baidu.tieba.write.model.a kQq;
    private com.baidu.tieba.write.transmit.model.a kQr;
    private com.baidu.tbadk.core.view.a kQs;
    public String mLat;
    public String mLng;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.j.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && view.getId() != 0) {
                if (view.getId() == R.id.icon_invoke_link) {
                    j.this.cUu();
                    TiebaStatic.log(new an("c12169"));
                }
                if (view.getId() == R.id.url_edit_back_view) {
                    j.this.cUt();
                }
            }
        }
    };
    private View.OnClickListener kQt = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.j.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && view.getId() == R.id.url_add) {
                TiebaStatic.log(new an("c12163"));
                String cUH = j.this.kQp.cUH();
                if (j.kQo.matcher(cUH).matches()) {
                    j.this.cUt();
                    j.this.kQq.Ku(cUH);
                    j.this.kQp.a(null, true);
                    return;
                }
                TiebaStatic.log(new an("c12164"));
                j.this.kQp.cUI();
            }
        }
    };
    private TextWatcher kQu = new TextWatcher() { // from class: com.baidu.tieba.write.write.j.3
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            j.this.kQp.cUz();
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (j.this.hbl != null) {
                if (!j.this.hbl.cRK()) {
                    j.this.tz(false);
                }
                j.this.hbl.tr(false);
            }
        }
    };
    private DialogInterface.OnCancelListener kQv = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.j.4
        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            if (j.this.kQr != null) {
                j.this.kQr.bDP();
            }
        }
    };
    private a.InterfaceC0621a kHi = new a.InterfaceC0621a() { // from class: com.baidu.tieba.write.write.j.5
        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0621a
        public void onError() {
            j.this.eH(null);
        }

        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0621a
        public void b(List<SimpleForum> list, int i) {
            j.this.eH(list);
        }
    };
    private a.InterfaceC0016a eoJ = new a.InterfaceC0016a() { // from class: com.baidu.tieba.write.write.j.6
        @Override // com.baidu.adp.lib.c.a.InterfaceC0016a
        public void onLocationGeted(int i, String str, Address address) {
            if (i == 0 && address != null) {
                j.this.mLat = String.valueOf(address.getLatitude());
                j.this.mLng = String.valueOf(address.getLongitude());
            }
        }
    };
    private final NewWriteModel.d dui = new NewWriteModel.d() { // from class: com.baidu.tieba.write.write.j.7
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, y yVar, WriteData writeData, AntiData antiData) {
            j.this.kQp.closeLoadingDialog();
            if (postWriteCallBackData != null) {
                j.this.hbl.aV(null);
                j.this.hbl.tq(false);
                if (z) {
                    String errorString = postWriteCallBackData.getErrorString();
                    String preMsg = postWriteCallBackData.getPreMsg();
                    String colorMsg = postWriteCallBackData.getColorMsg();
                    if (j.this.e(writeData)) {
                        com.baidu.tieba.tbadkCore.writeModel.c.f(j.this.cQU.getPageActivity(), errorString, preMsg, colorMsg);
                    }
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent.putExtras(bundle);
                    j.this.cQU.getPageActivity().setResult(-1, intent);
                    j.this.cQU.getPageActivity().finish();
                } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    j.this.cQU.showToast(postWriteCallBackData.getErrorString());
                    j.this.hbl.aV(postWriteCallBackData.getSensitiveWords());
                    j.this.hbl.Kn(postWriteCallBackData.getErrorString());
                    if (!v.isEmpty(j.this.hbl.cRH())) {
                        j.this.tz(true);
                    }
                } else if ((yVar == null || writeData == null || yVar.getVcode_pic_url() == null || AntiHelper.e(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                    j.this.kQp.l(postWriteCallBackData);
                } else if (yVar != null && writeData != null && yVar.getVcode_pic_url() != null) {
                    writeData.setVcodeMD5(yVar.getVcode_md5());
                    writeData.setVcodeUrl(yVar.getVcode_pic_url());
                    writeData.setVcodeExtra(yVar.aGR());
                    if (!com.baidu.tbadk.s.a.vB(yVar.aGQ())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(j.this.cQU.getPageActivity(), writeData, RequestResponseCode.REQUEST_VCODE)));
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(j.this.cQU.getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, false, yVar.aGQ())));
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(j.this.cQU.getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };

    public j(TbPageContext tbPageContext, k kVar, com.baidu.tieba.write.model.a aVar, WriteUrlModel writeUrlModel) {
        this.kQs = null;
        this.cQU = tbPageContext;
        this.kQp = kVar;
        this.kQq = aVar;
        this.kQk = writeUrlModel;
        this.kQp.ah(this.mClickListener);
        this.kQp.ai(this.kQt);
        this.kQp.f(this.kQu);
        cUu();
        this.kQs = new com.baidu.tbadk.core.view.a(this.cQU);
        this.kQs.setCancelListener(this.kQv);
        cUs();
        this.kQk.b(this.dui);
        this.hbl = new com.baidu.tieba.write.c();
        this.hbl.DO(R.color.cp_cont_a);
        this.hbl.DP(R.color.cp_cont_h_alpha85);
    }

    private void cUs() {
        this.kQr = new com.baidu.tieba.write.transmit.model.a(this.cQU.getUniqueId());
        this.kQr.a(this.kHi);
        if (this.kQk.cFi() != null) {
            this.kQr.setForumId(this.kQk.cFi().getForumId());
        }
    }

    protected void cUt() {
        this.kQp.cUG();
    }

    protected void cUu() {
        this.kQp.b((com.baidu.tieba.write.a.a) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eH(List<SimpleForum> list) {
        WriteData cFi = this.kQk.cFi();
        if (cFi != null) {
            this.kQs.setDialogVisiable(false);
            ArrayList<TransmitForumData> arrayList = new ArrayList<>();
            if (!StringUtils.isNull(cFi.getForumId()) && !cFi.getForumId().equals("0") && !StringUtils.isNull(cFi.getForumName())) {
                TransmitForumData transmitForumData = new TransmitForumData(com.baidu.adp.lib.f.b.toLong(cFi.getForumId(), 0L), cFi.getForumName(), true, 0);
                if (arrayList != null) {
                    arrayList.add(transmitForumData);
                }
            }
            if (v.getCount(list) > 0) {
                for (SimpleForum simpleForum : list) {
                    if (simpleForum != null && simpleForum.id != null && !StringUtils.isNull(simpleForum.name) && simpleForum.id.longValue() != com.baidu.adp.lib.f.b.toLong(cFi.getForumId(), 0L)) {
                        arrayList.add(new TransmitForumData(simpleForum.id.longValue(), simpleForum.name, false, 1));
                    }
                }
            }
            TransmitForumActivityConfig transmitForumActivityConfig = new TransmitForumActivityConfig(this.cQU.getPageActivity(), RequestResponseCode.REQUEST_SELECT_TRANSMIT_FORUM);
            CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, transmitForumActivityConfig);
            transmitForumActivityConfig.setRecommendForumList(arrayList);
            MessageManager.getInstance().sendMessage(customMessage);
        }
    }

    public void cJd() {
        if (ab.checkLocationForBaiduLocation(this.cQU.getPageActivity())) {
            com.baidu.adp.lib.c.a.fK().a(true, this.eoJ);
        }
    }

    public void destroy() {
        if (this.kQr != null) {
            this.kQr.destroy();
        }
        if (this.kQq != null) {
            this.kQq.destroy();
        }
        if (this.kQk != null) {
            this.kQk.cancelLoadData();
        }
    }

    public void btx() {
        this.kQr.setThreadContent(this.kQp.cUA());
        this.kQr.loadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tz(boolean z) {
        if (this.kQp.cUC() != null && this.kQp.cUA() != null) {
            int selectionEnd = this.kQp.cUC().getSelectionEnd();
            SpannableStringBuilder a = this.hbl.a(this.kQp.cUC().getText());
            if (a != null) {
                this.hbl.tr(true);
                this.kQp.cUC().setText(a);
                if (z && this.hbl.cRI() >= 0) {
                    this.kQp.cUC().requestFocus();
                    this.kQp.cUC().setSelection(this.hbl.cRI());
                } else {
                    this.kQp.cUC().setSelection(selectionEnd);
                }
                this.hbl.tq(this.hbl.cRI() >= 0);
            }
        }
    }

    public boolean cUv() {
        if (this.hbl.cRJ()) {
            this.cQU.showToast(this.hbl.cRL());
            tz(true);
            return true;
        }
        return false;
    }

    public void onChangeSkinType() {
        this.hbl.onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean e(WriteData writeData) {
        return writeData == null || !("1".equals(writeData.getCallFrom()) || "2".equals(writeData.getCallFrom()));
    }

    public void a(BaseActivity baseActivity, int i, int i2, Intent intent) {
        PostWriteCallBackData postWriteCallBackData;
        WriteData cFi;
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
                    this.cQU.getPageActivity().setResult(-1, intent2);
                }
                baseActivity.finish();
            } else if (i == 25013 && (cFi = this.kQk.cFi()) != null && this.kQq.cSx() != null) {
                if (intent != null) {
                    cFi.setTransmitForumData(intent.getStringExtra(TransmitForumActivityConfig.KEY_FORUM_LIST_SELECTED));
                }
                cFi.setForumId("0");
                cFi.setCanNoForum(true);
                cFi.setRecommendExt(this.kQr.getRecommendExt());
                if (!TextUtils.isEmpty(this.mLat) && !TextUtils.isEmpty(this.mLng)) {
                    cUw();
                } else if (ab.checkLocationForBaiduLocation(this.cQU.getPageActivity())) {
                    com.baidu.adp.lib.c.a.fK().a(true, new a.InterfaceC0016a() { // from class: com.baidu.tieba.write.write.j.8
                        @Override // com.baidu.adp.lib.c.a.InterfaceC0016a
                        public void onLocationGeted(int i3, String str, Address address) {
                            if (i3 == 0 && address != null) {
                                j.this.mLat = String.valueOf(address.getLatitude());
                                j.this.mLng = String.valueOf(address.getLongitude());
                            }
                            j.this.cUw();
                        }
                    });
                }
                this.kQp.showLoadingDialog();
            }
        } else if (i2 == 0) {
            switch (i) {
                case RequestResponseCode.REQUEST_VCODE /* 12006 */:
                    if (intent != null && intent.getExtras() != null && (intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData) && (postWriteCallBackData = (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data")) != null && postWriteCallBackData.isSensitiveError()) {
                        this.cQU.showToast(postWriteCallBackData.getErrorString());
                        this.hbl.aV(postWriteCallBackData.getSensitiveWords());
                        if (!v.isEmpty(this.hbl.cRH())) {
                            tz(true);
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

    public void cUw() {
        this.kQk.e("", this.kQp.cUA(), this.kQq.cSx().linkUrl, this.kQq.cSx().linkUrlCode, this.mLat, this.mLng);
    }
}
