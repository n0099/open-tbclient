package com.baidu.tieba.mention;

import android.app.Activity;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tieba.data.ar;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad extends BdAsyncTask<Object, Integer, String> {
    ArrayList<BasicNameValuePair> bmS;
    final /* synthetic */ x bnK;
    private final int bnk;
    private String mUrl;
    private String mUserName;
    private com.baidu.tbadk.core.util.ac yV;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        super.onPreExecute();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public String doInBackground(Object... objArr) {
        try {
            this.yV = new com.baidu.tbadk.core.util.ac(this.mUrl);
            this.yV.h(this.bmS);
            return this.yV.lA();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPostExecute(String str) {
        Activity activity;
        Activity activity2;
        Activity activity3;
        Activity activity4;
        Activity activity5;
        Activity activity6;
        Activity activity7;
        Activity activity8;
        Activity activity9;
        Activity activity10;
        try {
            if (this.yV != null && this.yV.mc().nb().jq()) {
                if (this.bnk == 1) {
                    com.baidu.tieba.data.ah ahVar = new com.baidu.tieba.data.ah();
                    ahVar.parserJson(str);
                    com.baidu.tieba.data.ak akVar = ahVar.zL().get(0);
                    if (akVar != null) {
                        int i = 0;
                        if (ahVar.getUserData() != null) {
                            i = ahVar.getUserData().getIsMem();
                        }
                        if (akVar.getId() != null) {
                            if (ahVar.jZ() == null || ahVar.jZ().getIfpost() != 0) {
                                activity9 = this.bnK.mActivity;
                                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WriteActivityConfig(activity9, 2, ahVar.zJ().getId(), ahVar.zJ().getName(), ahVar.zK().getId(), akVar.getId(), akVar.Ae(), ahVar.jZ(), 13001, false, ahVar.zP(), this.mUserName, false, false, null, null, null, i)));
                            } else {
                                activity10 = this.bnK.mActivity;
                                com.baidu.adp.lib.util.m.showToast(activity10, ahVar.jZ().getForbid_info());
                                return;
                            }
                        } else if (ahVar.jZ() == null || ahVar.jZ().getIfpost() != 0) {
                            activity7 = this.bnK.mActivity;
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WriteActivityConfig(activity7, 1, ahVar.zJ().getId(), ahVar.zJ().getName(), ahVar.zK().getId(), null, akVar.Ae(), ahVar.jZ(), 13002, false, ahVar.zP(), this.mUserName, false, false, null, null, null, i)));
                        } else {
                            activity8 = this.bnK.mActivity;
                            com.baidu.adp.lib.util.m.showToast(activity8, ahVar.jZ().getForbid_info());
                            return;
                        }
                    } else {
                        return;
                    }
                }
                if (this.bnk == 2) {
                    activity2 = this.bnK.mActivity;
                    ar TL = new com.baidu.tieba.model.an(activity2, str).TL();
                    String id = TL.Aw().getId();
                    String name = TL.Aw().getName();
                    String id2 = TL.Ay().getId();
                    AntiData An = TL.An();
                    String id3 = TL.As().getId();
                    int Ae = TL.As().Ae();
                    if (id3 != null) {
                        if (An == null || An.getIfpost() != 0) {
                            activity5 = this.bnK.mActivity;
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WriteActivityConfig(activity5, 2, id, name, id2, id3, Ae, An, 13001, false, true, this.mUserName, false, false, null, null, null, 0)));
                        } else {
                            activity6 = this.bnK.mActivity;
                            com.baidu.adp.lib.util.m.showToast(activity6, An.getForbid_info());
                            return;
                        }
                    } else if (An == null || An.getIfpost() != 0) {
                        activity3 = this.bnK.mActivity;
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WriteActivityConfig(activity3, 1, id, name, id2, null, Ae, An, 13002, false, true, this.mUserName, false, false, null, null, null, 0)));
                    } else {
                        activity4 = this.bnK.mActivity;
                        com.baidu.adp.lib.util.m.showToast(activity4, An.getForbid_info());
                        return;
                    }
                }
            } else if (this.yV != null) {
                activity = this.bnK.mActivity;
                com.baidu.adp.lib.util.m.showToast(activity, this.yV.getErrorString());
            }
        } catch (Exception e) {
        }
        this.bnK.bnI = null;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        if (this.yV != null) {
            this.yV.dM();
        }
        super.cancel(true);
    }
}
