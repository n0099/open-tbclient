package com.baidu.tieba.pb.pb.sub;

import android.util.SparseArray;
import android.view.View;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tieba.i;
import com.baidu.tieba.usermute.UserMuteAddAndDelModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements c.b {
    private final /* synthetic */ SparseArray cck;
    private final /* synthetic */ boolean ccl;
    private final /* synthetic */ String ccm;
    final /* synthetic */ NewSubPbActivity cgV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(NewSubPbActivity newSubPbActivity, SparseArray sparseArray, boolean z, String str) {
        this.cgV = newSubPbActivity;
        this.cck = sparseArray;
        this.ccl = z;
        this.ccm = str;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void itemClick(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        UserMuteAddAndDelModel userMuteAddAndDelModel;
        t tVar;
        switch (i) {
            case 0:
                String str = "";
                int intValue = this.cck.get(i.f.tag_del_post_type) instanceof Integer ? ((Integer) this.cck.get(i.f.tag_del_post_type)).intValue() : 0;
                if (this.cck.get(i.f.tag_del_post_id) instanceof String) {
                    str = (String) this.cck.get(i.f.tag_del_post_id);
                }
                int intValue2 = this.cck.get(i.f.tag_manage_user_identity) instanceof Integer ? ((Integer) this.cck.get(i.f.tag_manage_user_identity)).intValue() : 0;
                boolean booleanValue = this.cck.get(i.f.tag_del_post_is_self) instanceof Boolean ? ((Boolean) this.cck.get(i.f.tag_del_post_is_self)).booleanValue() : false;
                tVar = this.cgV.cgO;
                tVar.a(intValue, str, intValue2, booleanValue);
                break;
            case 1:
                String str2 = "";
                String str3 = "";
                String str4 = "";
                if (this.cck.get(i.f.tag_disable_reply_mute_username) instanceof String) {
                    str2 = (String) this.cck.get(i.f.tag_disable_reply_mute_username);
                }
                if (this.cck.get(i.f.tag_disable_reply_thread_id) instanceof String) {
                    str3 = (String) this.cck.get(i.f.tag_disable_reply_thread_id);
                }
                if (this.cck.get(i.f.tag_disable_reply_post_id) instanceof String) {
                    str4 = (String) this.cck.get(i.f.tag_disable_reply_post_id);
                }
                userMuteAddAndDelModel = this.cgV.cbJ;
                userMuteAddAndDelModel.a(this.ccl, this.ccm, str2, str3, str4, UserMuteAddAndDelModel.From.PB);
                break;
        }
        cVar.dismiss();
    }
}
