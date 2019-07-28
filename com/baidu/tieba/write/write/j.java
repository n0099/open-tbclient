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
import com.baidu.tbadk.coreExtra.data.x;
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
    private static final Pattern jUQ = Pattern.compile("[ ]*http(s)?://([\\w-]+\\.)+[\\w-]+(/[\\w- ./?#%&=]*)?", 2);
    public com.baidu.tieba.write.b gmt;
    private WriteUrlModel jUM;
    private k jUR;
    private com.baidu.tieba.write.model.a jUS;
    private com.baidu.tieba.write.transmit.model.a jUT;
    private com.baidu.tbadk.core.view.b jUU;
    private TbPageContext mContext;
    public String mLat;
    public String mLng;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.j.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && view.getId() != 0) {
                if (view.getId() == R.id.icon_invoke_link) {
                    j.this.cCC();
                    TiebaStatic.log(new an("c12169"));
                }
                if (view.getId() == R.id.url_edit_back_view) {
                    j.this.cCB();
                }
            }
        }
    };
    private View.OnClickListener jUV = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.j.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && view.getId() == R.id.url_add) {
                TiebaStatic.log(new an("c12163"));
                String cCP = j.this.jUR.cCP();
                if (j.jUQ.matcher(cCP).matches()) {
                    j.this.cCB();
                    j.this.jUS.GK(cCP);
                    j.this.jUR.a(null, true);
                    return;
                }
                TiebaStatic.log(new an("c12164"));
                j.this.jUR.cCQ();
            }
        }
    };
    private TextWatcher jUW = new TextWatcher() { // from class: com.baidu.tieba.write.write.j.3
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            j.this.jUR.cCH();
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (j.this.gmt != null) {
                if (!j.this.gmt.czh()) {
                    j.this.sj(false);
                }
                j.this.gmt.sa(false);
            }
        }
    };
    private DialogInterface.OnCancelListener jUX = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.j.4
        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            if (j.this.jUT != null) {
                j.this.jUT.bos();
            }
        }
    };
    private a.InterfaceC0435a jLf = new a.InterfaceC0435a() { // from class: com.baidu.tieba.write.write.j.5
        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0435a
        public void onError() {
            j.this.eD(null);
        }

        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0435a
        public void g(List<SimpleForum> list, int i) {
            j.this.eD(list);
        }
    };
    private a.InterfaceC0015a dwk = new a.InterfaceC0015a() { // from class: com.baidu.tieba.write.write.j.6
        @Override // com.baidu.adp.lib.d.a.InterfaceC0015a
        public void b(int i, String str, Address address) {
            if (i == 0 && address != null) {
                j.this.mLat = String.valueOf(address.getLatitude());
                j.this.mLng = String.valueOf(address.getLongitude());
            }
        }
    };
    private final NewWriteModel.d ctR = new NewWriteModel.d() { // from class: com.baidu.tieba.write.write.j.7
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, x xVar, WriteData writeData, AntiData antiData) {
            j.this.jUR.closeLoadingDialog();
            if (postWriteCallBackData != null) {
                j.this.gmt.aI(null);
                j.this.gmt.rZ(false);
                if (z) {
                    String errorString = postWriteCallBackData.getErrorString();
                    String preMsg = postWriteCallBackData.getPreMsg();
                    String colorMsg = postWriteCallBackData.getColorMsg();
                    if (j.this.d(writeData)) {
                        com.baidu.tieba.tbadkCore.writeModel.c.f(j.this.mContext.getPageActivity(), errorString, preMsg, colorMsg);
                    }
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent.putExtras(bundle);
                    j.this.mContext.getPageActivity().setResult(-1, intent);
                    j.this.mContext.getPageActivity().finish();
                } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    j.this.mContext.showToast(postWriteCallBackData.getErrorString());
                    j.this.gmt.aI(postWriteCallBackData.getSensitiveWords());
                    j.this.gmt.GA(postWriteCallBackData.getErrorString());
                    if (!v.aa(j.this.gmt.cze())) {
                        j.this.sj(true);
                    }
                } else if ((xVar == null || writeData == null || xVar.getVcode_pic_url() == null || AntiHelper.e(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                    j.this.jUR.l(postWriteCallBackData);
                } else if (xVar != null && writeData != null && xVar.getVcode_pic_url() != null) {
                    writeData.setVcodeMD5(xVar.getVcode_md5());
                    writeData.setVcodeUrl(xVar.getVcode_pic_url());
                    writeData.setVcodeExtra(xVar.amF());
                    if (!com.baidu.tbadk.v.a.ru(xVar.amE())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(j.this.mContext.getPageActivity(), writeData, 12006)));
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(j.this.mContext.getPageActivity(), 12006, writeData, false, xVar.amE())));
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(j.this.mContext.getPageActivity(), 12006, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };

    public j(TbPageContext tbPageContext, k kVar, com.baidu.tieba.write.model.a aVar, WriteUrlModel writeUrlModel) {
        this.jUU = null;
        this.mContext = tbPageContext;
        this.jUR = kVar;
        this.jUS = aVar;
        this.jUM = writeUrlModel;
        this.jUR.ae(this.mClickListener);
        this.jUR.af(this.jUV);
        this.jUR.g(this.jUW);
        cCC();
        this.jUU = new com.baidu.tbadk.core.view.b(this.mContext);
        this.jUU.e(this.jUX);
        cCA();
        this.jUM.b(this.ctR);
        this.gmt = new com.baidu.tieba.write.b();
        this.gmt.CI(R.color.cp_btn_a);
        this.gmt.CJ(R.color.cp_cont_h_alpha85);
    }

    private void cCA() {
        this.jUT = new com.baidu.tieba.write.transmit.model.a(this.mContext.getUniqueId());
        this.jUT.a(this.jLf);
        if (this.jUM.getWriteData() != null) {
            this.jUT.setForumId(this.jUM.getWriteData().getForumId());
        }
    }

    protected void cCB() {
        this.jUR.cCO();
    }

    protected void cCC() {
        this.jUR.b((com.baidu.tieba.write.a.a) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eD(List<SimpleForum> list) {
        WriteData writeData = this.jUM.getWriteData();
        if (writeData != null) {
            this.jUU.ej(false);
            ArrayList<TransmitForumData> arrayList = new ArrayList<>();
            if (!StringUtils.isNull(writeData.getForumId()) && !writeData.getForumId().equals("0") && !StringUtils.isNull(writeData.getForumName())) {
                TransmitForumData transmitForumData = new TransmitForumData(com.baidu.adp.lib.g.b.c(writeData.getForumId(), 0L), writeData.getForumName(), true, 0);
                if (arrayList != null) {
                    arrayList.add(transmitForumData);
                }
            }
            if (v.Z(list) > 0) {
                for (SimpleForum simpleForum : list) {
                    if (simpleForum != null && simpleForum.id != null && !StringUtils.isNull(simpleForum.name) && simpleForum.id.longValue() != com.baidu.adp.lib.g.b.c(writeData.getForumId(), 0L)) {
                        arrayList.add(new TransmitForumData(simpleForum.id.longValue(), simpleForum.name, false, 1));
                    }
                }
            }
            TransmitForumActivityConfig transmitForumActivityConfig = new TransmitForumActivityConfig(this.mContext.getPageActivity(), 25013);
            CustomMessage customMessage = new CustomMessage(2002001, transmitForumActivityConfig);
            transmitForumActivityConfig.setRecommendForumList(arrayList);
            MessageManager.getInstance().sendMessage(customMessage);
        }
    }

    public void cpX() {
        if (ab.cw(this.mContext.getPageActivity())) {
            com.baidu.adp.lib.d.a.hY().a(true, this.dwk);
        }
    }

    public void destroy() {
        if (this.jUT != null) {
            this.jUT.destroy();
        }
        if (this.jUS != null) {
            this.jUS.destroy();
        }
        if (this.jUM != null) {
            this.jUM.cancelLoadData();
        }
    }

    public void bbr() {
        this.jUT.setThreadContent(this.jUR.cCI());
        this.jUT.loadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sj(boolean z) {
        if (this.jUR.cCK() != null && this.jUR.cCI() != null) {
            int selectionEnd = this.jUR.cCK().getSelectionEnd();
            SpannableStringBuilder b = this.gmt.b(this.jUR.cCK().getText());
            if (b != null) {
                this.gmt.sa(true);
                this.jUR.cCK().setText(b);
                if (z && this.gmt.czf() >= 0) {
                    this.jUR.cCK().requestFocus();
                    this.jUR.cCK().setSelection(this.gmt.czf());
                } else {
                    this.jUR.cCK().setSelection(selectionEnd);
                }
                this.gmt.rZ(this.gmt.czf() >= 0);
            }
        }
    }

    public boolean cCD() {
        if (this.gmt.czg()) {
            this.mContext.showToast(this.gmt.czi());
            sj(true);
            return true;
        }
        return false;
    }

    public void onChangeSkinType() {
        this.gmt.onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean d(WriteData writeData) {
        return writeData == null || !("1".equals(writeData.getCallFrom()) || "2".equals(writeData.getCallFrom()));
    }

    public void a(BaseActivity baseActivity, int i, int i2, Intent intent) {
        PostWriteCallBackData postWriteCallBackData;
        WriteData writeData;
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
                    this.mContext.getPageActivity().setResult(-1, intent2);
                }
                baseActivity.finish();
            } else if (i == 25013 && (writeData = this.jUM.getWriteData()) != null && this.jUS.cAE() != null) {
                if (intent != null) {
                    writeData.setTransmitForumData(intent.getStringExtra(TransmitForumActivityConfig.KEY_FORUM_LIST_SELECTED));
                }
                writeData.setForumId("0");
                writeData.setCanNoForum(true);
                writeData.setRecommendExt(this.jUT.getRecommendExt());
                if (!TextUtils.isEmpty(this.mLat) && !TextUtils.isEmpty(this.mLng)) {
                    cCE();
                } else if (ab.cw(this.mContext.getPageActivity())) {
                    com.baidu.adp.lib.d.a.hY().a(true, new a.InterfaceC0015a() { // from class: com.baidu.tieba.write.write.j.8
                        @Override // com.baidu.adp.lib.d.a.InterfaceC0015a
                        public void b(int i3, String str, Address address) {
                            if (i3 == 0 && address != null) {
                                j.this.mLat = String.valueOf(address.getLatitude());
                                j.this.mLng = String.valueOf(address.getLongitude());
                            }
                            j.this.cCE();
                        }
                    });
                }
                this.jUR.showLoadingDialog();
            }
        } else if (i2 == 0) {
            switch (i) {
                case 12006:
                    if (intent != null && intent.getExtras() != null && (intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData) && (postWriteCallBackData = (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data")) != null && postWriteCallBackData.isSensitiveError()) {
                        this.mContext.showToast(postWriteCallBackData.getErrorString());
                        this.gmt.aI(postWriteCallBackData.getSensitiveWords());
                        if (!v.aa(this.gmt.cze())) {
                            sj(true);
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

    public void cCE() {
        this.jUM.g("", this.jUR.cCI(), this.jUS.cAE().linkUrl, this.jUS.cAE().linkUrlCode, this.mLat, this.mLng);
    }
}
