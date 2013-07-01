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

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NearbyPostActivity f1132a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(NearbyPostActivity nearbyPostActivity) {
        this.f1132a = nearbyPostActivity;
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
            case R.id.nearby_post_layout /* 2131100289 */:
            case R.id.nearby_reply_layout /* 2131100306 */:
                String str10 = (String) view.getTag(R.id.tag_nearby_thread_id);
                String str11 = (String) view.getTag(R.id.tag_nearby_url);
                Boolean bool = (Boolean) view.getTag(R.id.tag_nearby_guid_post);
                if (str10 != null && !str10.equals("")) {
                    NearbyPbActivity.a(this.f1132a.getParent(), str10, "tb_suishoufa", false, 1300006);
                    return;
                } else if (str11 != null && !str11.equals("")) {
                    if (bool.booleanValue()) {
                        if (TiebaApplication.f().t()) {
                            StatService.onEvent(this.f1132a, "lbs_new_guid_post", "lbsclick", 1);
                        }
                    } else if (TiebaApplication.f().t()) {
                        StatService.onEvent(this.f1132a, "lbs_operation_post", "lbsclick", 1);
                    }
                    this.f1132a.c(str11);
                    return;
                } else {
                    return;
                }
            case R.id.author_photo /* 2131100303 */:
            case R.id.author_name /* 2131100304 */:
                String str12 = (String) view.getTag(R.id.tag_nearby_person_id);
                String str13 = (String) view.getTag(R.id.tag_nearby_person_name);
                if (str13 != null && str12 != null && !str13.equals("") && !str12.equals("")) {
                    PersonInfoActivity.a(this.f1132a, str12, str13);
                    return;
                }
                return;
            case R.id.comment_btn /* 2131100305 */:
                this.f1132a.q = (String) view.getTag(R.id.tag_nearby_thread_id);
                this.f1132a.r = (String) view.getTag(R.id.tag_nearby_forum_name);
                this.f1132a.s = (String) view.getTag(R.id.tag_nearby_forum_id);
                str = this.f1132a.q;
                if (str != null) {
                    str2 = this.f1132a.q;
                    if (!str2.equals("")) {
                        str3 = this.f1132a.r;
                        if (str3 != null) {
                            str4 = this.f1132a.r;
                            if (!str4.equals("")) {
                                str5 = this.f1132a.s;
                                if (str5 != null) {
                                    str6 = this.f1132a.s;
                                    if (!str6.equals("")) {
                                        String E = TiebaApplication.E();
                                        if (E == null || E.length() <= 0) {
                                            LoginActivity.a(this.f1132a.getParent(), this.f1132a.getString(R.string.login_to_post), true, 1100024);
                                            return;
                                        }
                                        Activity parent = this.f1132a.getParent();
                                        str7 = this.f1132a.s;
                                        str8 = this.f1132a.r;
                                        str9 = this.f1132a.q;
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
