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
    private static final Pattern jYt = Pattern.compile("[ ]*http(s)?://([\\w-]+\\.)+[\\w-]+(/[\\w- ./?#%&=]*)?", 2);
    public com.baidu.tieba.write.b gpc;
    private WriteUrlModel jYp;
    private k jYu;
    private com.baidu.tieba.write.model.a jYv;
    private com.baidu.tieba.write.transmit.model.a jYw;
    private com.baidu.tbadk.core.view.b jYx;
    private TbPageContext mContext;
    public String mLat;
    public String mLng;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.j.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && view.getId() != 0) {
                if (view.getId() == R.id.icon_invoke_link) {
                    j.this.cDL();
                    TiebaStatic.log(new an("c12169"));
                }
                if (view.getId() == R.id.url_edit_back_view) {
                    j.this.cDK();
                }
            }
        }
    };
    private View.OnClickListener jYy = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.j.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && view.getId() == R.id.url_add) {
                TiebaStatic.log(new an("c12163"));
                String cDY = j.this.jYu.cDY();
                if (j.jYt.matcher(cDY).matches()) {
                    j.this.cDK();
                    j.this.jYv.Hl(cDY);
                    j.this.jYu.a(null, true);
                    return;
                }
                TiebaStatic.log(new an("c12164"));
                j.this.jYu.cDZ();
            }
        }
    };
    private TextWatcher jYz = new TextWatcher() { // from class: com.baidu.tieba.write.write.j.3
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            j.this.jYu.cDQ();
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (j.this.gpc != null) {
                if (!j.this.gpc.cAq()) {
                    j.this.sn(false);
                }
                j.this.gpc.se(false);
            }
        }
    };
    private DialogInterface.OnCancelListener jYA = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.j.4
        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            if (j.this.jYw != null) {
                j.this.jYw.bpq();
            }
        }
    };
    private a.InterfaceC0446a jOH = new a.InterfaceC0446a() { // from class: com.baidu.tieba.write.write.j.5
        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0446a
        public void onError() {
            j.this.eC(null);
        }

        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0446a
        public void g(List<SimpleForum> list, int i) {
            j.this.eC(list);
        }
    };
    private a.InterfaceC0015a dyc = new a.InterfaceC0015a() { // from class: com.baidu.tieba.write.write.j.6
        @Override // com.baidu.adp.lib.d.a.InterfaceC0015a
        public void b(int i, String str, Address address) {
            if (i == 0 && address != null) {
                j.this.mLat = String.valueOf(address.getLatitude());
                j.this.mLng = String.valueOf(address.getLongitude());
            }
        }
    };
    private final NewWriteModel.d cuV = new NewWriteModel.d() { // from class: com.baidu.tieba.write.write.j.7
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, y yVar, WriteData writeData, AntiData antiData) {
            j.this.jYu.closeLoadingDialog();
            if (postWriteCallBackData != null) {
                j.this.gpc.aI(null);
                j.this.gpc.sd(false);
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
                    j.this.gpc.aI(postWriteCallBackData.getSensitiveWords());
                    j.this.gpc.Hb(postWriteCallBackData.getErrorString());
                    if (!v.aa(j.this.gpc.cAn())) {
                        j.this.sn(true);
                    }
                } else if ((yVar == null || writeData == null || yVar.getVcode_pic_url() == null || AntiHelper.e(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                    j.this.jYu.l(postWriteCallBackData);
                } else if (yVar != null && writeData != null && yVar.getVcode_pic_url() != null) {
                    writeData.setVcodeMD5(yVar.getVcode_md5());
                    writeData.setVcodeUrl(yVar.getVcode_pic_url());
                    writeData.setVcodeExtra(yVar.amT());
                    if (!com.baidu.tbadk.v.a.rF(yVar.amS())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(j.this.mContext.getPageActivity(), writeData, 12006)));
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(j.this.mContext.getPageActivity(), 12006, writeData, false, yVar.amS())));
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(j.this.mContext.getPageActivity(), 12006, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };

    public j(TbPageContext tbPageContext, k kVar, com.baidu.tieba.write.model.a aVar, WriteUrlModel writeUrlModel) {
        this.jYx = null;
        this.mContext = tbPageContext;
        this.jYu = kVar;
        this.jYv = aVar;
        this.jYp = writeUrlModel;
        this.jYu.ae(this.mClickListener);
        this.jYu.af(this.jYy);
        this.jYu.g(this.jYz);
        cDL();
        this.jYx = new com.baidu.tbadk.core.view.b(this.mContext);
        this.jYx.e(this.jYA);
        cDJ();
        this.jYp.b(this.cuV);
        this.gpc = new com.baidu.tieba.write.b();
        this.gpc.CO(R.color.cp_cont_a);
        this.gpc.CP(R.color.cp_cont_h_alpha85);
    }

    private void cDJ() {
        this.jYw = new com.baidu.tieba.write.transmit.model.a(this.mContext.getUniqueId());
        this.jYw.a(this.jOH);
        if (this.jYp.getWriteData() != null) {
            this.jYw.setForumId(this.jYp.getWriteData().getForumId());
        }
    }

    protected void cDK() {
        this.jYu.cDX();
    }

    protected void cDL() {
        this.jYu.b((com.baidu.tieba.write.a.a) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eC(List<SimpleForum> list) {
        WriteData writeData = this.jYp.getWriteData();
        if (writeData != null) {
            this.jYx.em(false);
            ArrayList<TransmitForumData> arrayList = new ArrayList<>();
            if (!StringUtils.isNull(writeData.getForumId()) && !writeData.getForumId().equals("0") && !StringUtils.isNull(writeData.getForumName())) {
                TransmitForumData transmitForumData = new TransmitForumData(com.baidu.adp.lib.g.b.e(writeData.getForumId(), 0L), writeData.getForumName(), true, 0);
                if (arrayList != null) {
                    arrayList.add(transmitForumData);
                }
            }
            if (v.Z(list) > 0) {
                for (SimpleForum simpleForum : list) {
                    if (simpleForum != null && simpleForum.id != null && !StringUtils.isNull(simpleForum.name) && simpleForum.id.longValue() != com.baidu.adp.lib.g.b.e(writeData.getForumId(), 0L)) {
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

    public void crh() {
        if (ab.cw(this.mContext.getPageActivity())) {
            com.baidu.adp.lib.d.a.hY().a(true, this.dyc);
        }
    }

    public void destroy() {
        if (this.jYw != null) {
            this.jYw.destroy();
        }
        if (this.jYv != null) {
            this.jYv.destroy();
        }
        if (this.jYp != null) {
            this.jYp.cancelLoadData();
        }
    }

    public void bbX() {
        this.jYw.setThreadContent(this.jYu.cDR());
        this.jYw.loadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sn(boolean z) {
        if (this.jYu.cDT() != null && this.jYu.cDR() != null) {
            int selectionEnd = this.jYu.cDT().getSelectionEnd();
            SpannableStringBuilder b = this.gpc.b(this.jYu.cDT().getText());
            if (b != null) {
                this.gpc.se(true);
                this.jYu.cDT().setText(b);
                if (z && this.gpc.cAo() >= 0) {
                    this.jYu.cDT().requestFocus();
                    this.jYu.cDT().setSelection(this.gpc.cAo());
                } else {
                    this.jYu.cDT().setSelection(selectionEnd);
                }
                this.gpc.sd(this.gpc.cAo() >= 0);
            }
        }
    }

    public boolean cDM() {
        if (this.gpc.cAp()) {
            this.mContext.showToast(this.gpc.cAr());
            sn(true);
            return true;
        }
        return false;
    }

    public void onChangeSkinType() {
        this.gpc.onChangeSkinType();
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
            } else if (i == 25013 && (writeData = this.jYp.getWriteData()) != null && this.jYv.cBN() != null) {
                if (intent != null) {
                    writeData.setTransmitForumData(intent.getStringExtra(TransmitForumActivityConfig.KEY_FORUM_LIST_SELECTED));
                }
                writeData.setForumId("0");
                writeData.setCanNoForum(true);
                writeData.setRecommendExt(this.jYw.getRecommendExt());
                if (!TextUtils.isEmpty(this.mLat) && !TextUtils.isEmpty(this.mLng)) {
                    cDN();
                } else if (ab.cw(this.mContext.getPageActivity())) {
                    com.baidu.adp.lib.d.a.hY().a(true, new a.InterfaceC0015a() { // from class: com.baidu.tieba.write.write.j.8
                        @Override // com.baidu.adp.lib.d.a.InterfaceC0015a
                        public void b(int i3, String str, Address address) {
                            if (i3 == 0 && address != null) {
                                j.this.mLat = String.valueOf(address.getLatitude());
                                j.this.mLng = String.valueOf(address.getLongitude());
                            }
                            j.this.cDN();
                        }
                    });
                }
                this.jYu.showLoadingDialog();
            }
        } else if (i2 == 0) {
            switch (i) {
                case 12006:
                    if (intent != null && intent.getExtras() != null && (intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData) && (postWriteCallBackData = (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data")) != null && postWriteCallBackData.isSensitiveError()) {
                        this.mContext.showToast(postWriteCallBackData.getErrorString());
                        this.gpc.aI(postWriteCallBackData.getSensitiveWords());
                        if (!v.aa(this.gpc.cAn())) {
                            sn(true);
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

    public void cDN() {
        this.jYp.g("", this.jYu.cDR(), this.jYv.cBN().linkUrl, this.jYv.cBN().linkUrlCode, this.mLat, this.mLng);
    }
}
