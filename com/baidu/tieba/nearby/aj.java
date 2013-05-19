package com.baidu.tieba.nearby;

import android.app.Activity;
import android.view.View;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.account.LoginActivity;
import com.baidu.tieba.person.PersonInfoActivity;
import com.baidu.tieba.write.WriteActivity;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj implements View.OnClickListener {
    final /* synthetic */ NearbyPostActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(NearbyPostActivity nearbyPostActivity) {
        this.a = nearbyPostActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        switch (view.getId()) {
            case R.id.nearby_post_layout /* 2131100200 */:
            case R.id.nearby_reply_layout /* 2131100218 */:
                String str10 = (String) view.getTag(R.id.tag_nearby_thread_id);
                String str11 = (String) view.getTag(R.id.tag_nearby_url);
                Boolean bool = (Boolean) view.getTag(R.id.tag_nearby_guid_post);
                if (str10 != null && !str10.equals("")) {
                    NearbyPbActivity.a(this.a.getParent(), str10, "tb_suishoufa", false, 1300006);
                    return;
                } else if (str11 != null && !str11.equals("")) {
                    if (bool.booleanValue()) {
                        if (TiebaApplication.d().n()) {
                            StatService.onEvent(this.a, "lbs_new_guid_post", "lbsclick", 1);
                        }
                    } else if (TiebaApplication.d().n()) {
                        StatService.onEvent(this.a, "lbs_operation_post", "lbsclick", 1);
                    }
                    this.a.c(str11);
                    return;
                } else {
                    return;
                }
            case R.id.author_photo /* 2131100215 */:
            case R.id.author_name /* 2131100216 */:
                String str12 = (String) view.getTag(R.id.tag_nearby_person_id);
                String str13 = (String) view.getTag(R.id.tag_nearby_person_name);
                if (str13 != null && str12 != null && !str13.equals("") && !str12.equals("")) {
                    PersonInfoActivity.a(this.a, str12, str13);
                    return;
                }
                return;
            case R.id.comment_btn /* 2131100217 */:
                this.a.q = (String) view.getTag(R.id.tag_nearby_thread_id);
                this.a.r = (String) view.getTag(R.id.tag_nearby_forum_name);
                this.a.s = (String) view.getTag(R.id.tag_nearby_forum_id);
                str = this.a.q;
                if (str != null) {
                    str2 = this.a.q;
                    if (!str2.equals("")) {
                        str3 = this.a.r;
                        if (str3 != null) {
                            str4 = this.a.r;
                            if (!str4.equals("")) {
                                str5 = this.a.s;
                                if (str5 != null) {
                                    str6 = this.a.s;
                                    if (!str6.equals("")) {
                                        String z = TiebaApplication.z();
                                        if (z == null || z.length() <= 0) {
                                            LoginActivity.a(this.a.getParent(), this.a.getString(R.string.login_to_post), true, 1100024);
                                            return;
                                        }
                                        Activity parent = this.a.getParent();
                                        str7 = this.a.s;
                                        str8 = this.a.r;
                                        str9 = this.a.q;
                                        WriteActivity.a(parent, str7, str8, str9);
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                            return;
                        }
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
