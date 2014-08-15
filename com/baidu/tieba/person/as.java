package com.baidu.tieba.person;

import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.TiebaStatic;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class as {
    private Context a;
    private BaseFragmentActivity b;
    private PersonCenterListTopData d;
    private String e = "";
    private View.OnClickListener c = new at(this);

    public as(Context context, PersonCenterListTopData personCenterListTopData) {
        this.a = context;
        this.b = (BaseFragmentActivity) this.a;
        this.d = personCenterListTopData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        TiebaStatic.eventStat(this.a, "enter_chat", "personclick", 1, new Object[0]);
        try {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new com.baidu.tbadk.core.atomData.bj(this.a, Long.parseLong(this.d.getmModel().k().getUserId()), this.d.getmModel().k().getUserName(), this.d.getmModel().k().getPortrait(), this.d.getmModel().k().getSex())));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public View a() {
        LayoutInflater layoutInflater = (LayoutInflater) this.a.getSystemService("layout_inflater");
        if (this.d.getmDataType() == 3) {
            ay ayVar = new ay();
            View inflate = layoutInflater.inflate(com.baidu.tieba.v.person_center_accpet_card_view, (ViewGroup) null);
            ayVar.a = inflate;
            ayVar.c = (TextView) inflate.findViewById(com.baidu.tieba.u.not_friend);
            ayVar.d = (LinearLayout) inflate.findViewById(com.baidu.tieba.u.viewcontent);
            ayVar.b = (LinearLayout) inflate.findViewById(com.baidu.tieba.u.add_content);
            ayVar.e = (LinearLayout) ayVar.d.findViewById(com.baidu.tieba.u.topbuttonview_content);
            ayVar.f = (LinearLayout) inflate.findViewById(com.baidu.tieba.u.topattention_content);
            ayVar.g = (ImageView) ayVar.f.findViewById(com.baidu.tieba.u.tagiconimageview);
            ayVar.h = (TextView) ayVar.f.findViewById(com.baidu.tieba.u.tagtextview);
            ayVar.e.setOnClickListener(this.c);
            ayVar.f.setOnClickListener(this.c);
            inflate.setTag(ayVar);
            return inflate;
        }
        az azVar = new az();
        View inflate2 = layoutInflater.inflate(com.baidu.tieba.v.person_center_topbutton_view, (ViewGroup) null);
        azVar.a = inflate2.findViewById(com.baidu.tieba.u.content);
        azVar.b = (LinearLayout) inflate2.findViewById(com.baidu.tieba.u.add_content);
        azVar.c = (TextView) inflate2.findViewById(com.baidu.tieba.u.not_friend);
        azVar.d = (LinearLayout) inflate2.findViewById(com.baidu.tieba.u.topbuttonview_content);
        azVar.e = (ImageView) azVar.d.findViewById(com.baidu.tieba.u.tagiconimageview);
        azVar.f = (TextView) azVar.d.findViewById(com.baidu.tieba.u.tagtextview);
        azVar.g = (LinearLayout) inflate2.findViewById(com.baidu.tieba.u.topattention_content);
        azVar.h = (ImageView) azVar.g.findViewById(com.baidu.tieba.u.tagiconimageview);
        azVar.i = (TextView) azVar.g.findViewById(com.baidu.tieba.u.tagtextview);
        azVar.d.setOnClickListener(this.c);
        azVar.g.setOnClickListener(this.c);
        inflate2.setTag(azVar);
        return inflate2;
    }

    public void a(ViewGroup viewGroup) {
        int size;
        if (this.d != null && this.d.getmModel() != null && this.d.getmModel().a() != null) {
            ArrayList<cb> h = this.d.getmModel().a().h();
            UserData k = this.d.getmModel().k();
            if (h != null && k != null && (size = h.size()) != 0) {
                LayoutInflater from = LayoutInflater.from(this.a);
                for (int i = 0; i < size; i++) {
                    View inflate = from.inflate(com.baidu.tieba.v.apply_message, (ViewGroup) null);
                    View findViewById = inflate.findViewById(com.baidu.tieba.u.line);
                    TextView textView = (TextView) inflate.findViewById(com.baidu.tieba.u.apply_name);
                    TextView textView2 = (TextView) inflate.findViewById(com.baidu.tieba.u.apply_info);
                    TextView textView3 = (TextView) inflate.findViewById(com.baidu.tieba.u.reply_btn);
                    if (i == size - 1) {
                        textView3.setVisibility(0);
                        com.baidu.tbadk.core.util.ay.a(textView3, com.baidu.tieba.r.cp_cont_b, 1);
                        com.baidu.tbadk.core.util.ay.f((View) textView3, com.baidu.tieba.t.btn_pass_n);
                    }
                    com.baidu.tbadk.core.util.ay.f(findViewById, com.baidu.tieba.r.cp_bg_line_b);
                    if (h.get(i).a == k.getUserIdLong()) {
                        textView.setText(String.valueOf(k.getName_show()) + ":");
                        textView2.setText(h.get(i).c);
                        com.baidu.tbadk.core.util.ay.a(textView, com.baidu.tieba.r.cp_cont_d, 1);
                        com.baidu.tbadk.core.util.ay.a(textView2, com.baidu.tieba.r.cp_cont_d, 1);
                    } else {
                        textView.setText(String.valueOf(this.a.getResources().getString(com.baidu.tieba.x.me)) + ":");
                        textView2.setText(h.get(i).c);
                        com.baidu.tbadk.core.util.ay.a(textView, com.baidu.tieba.r.cp_cont_b, 1);
                        com.baidu.tbadk.core.util.ay.a(textView2, com.baidu.tieba.r.cp_cont_b, 1);
                    }
                    textView3.setOnClickListener(new au(this, k));
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                    layoutParams.leftMargin = this.a.getResources().getDimensionPixelSize(com.baidu.tieba.s.ds24);
                    layoutParams.rightMargin = this.a.getResources().getDimensionPixelSize(com.baidu.tieba.s.ds24);
                    viewGroup.addView(inflate, layoutParams);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(UserData userData) {
        View inflate = LayoutInflater.from(this.a).inflate(com.baidu.tieba.v.reply_dialog, (ViewGroup) null);
        EditText editText = (EditText) inflate.findViewById(com.baidu.tieba.u.reply_message);
        com.baidu.tbadk.core.util.ay.f((View) editText, com.baidu.tieba.t.bg_live_compile);
        com.baidu.tbadk.core.util.ay.a(editText, com.baidu.tieba.r.cp_cont_b, 2);
        editText.setPadding(this.a.getResources().getDimensionPixelSize(com.baidu.tieba.s.ds16), 0, 0, 0);
        editText.setFocusable(true);
        editText.requestFocus();
        new Handler().postDelayed(new av(this, editText), 100L);
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.b);
        aVar.a(this.a.getResources().getString(com.baidu.tieba.x.add_reply));
        aVar.b(this.a.getResources().getString(com.baidu.tieba.x.delete_account_cancle), new aw(this));
        aVar.a(this.a.getResources().getString(com.baidu.tieba.x.reply_message), new ax(this, editText, userData));
        aVar.a(inflate);
        aVar.a().b();
    }

    public void a(View view) {
        boolean z = false;
        if (view.getTag() != null) {
            if (this.d.getmDataType() == 3) {
                ay ayVar = (ay) view.getTag();
                if (ayVar != null) {
                    a((ViewGroup) ayVar.b);
                    this.b.c().a(TbadkApplication.m252getInst().getSkinType() == 1);
                    this.b.c().a(ayVar.a);
                    if (this.d != null && this.d.getmModel() != null && this.d.getmModel().k() != null && this.d.getmModel().k().getHave_attention() == 1) {
                        z = true;
                    }
                    if (z) {
                        com.baidu.tbadk.core.util.ay.f(ayVar.f, com.baidu.tieba.t.btn_pop_news);
                        com.baidu.tbadk.core.util.ay.c(ayVar.g, com.baidu.tieba.t.icon_pop_cancel_blue);
                        com.baidu.tbadk.core.util.ay.a(ayVar.h, com.baidu.tieba.r.cp_link_tip_c, 1);
                        ayVar.h.setText(this.a.getString(com.baidu.tieba.x.attention_cancel));
                    } else {
                        com.baidu.tbadk.core.util.ay.f(ayVar.f, com.baidu.tieba.t.btn_pop_news);
                        com.baidu.tbadk.core.util.ay.c(ayVar.g, com.baidu.tieba.t.icon_pop_add_blue);
                        com.baidu.tbadk.core.util.ay.a(ayVar.h, com.baidu.tieba.r.cp_link_tip_c, 1);
                        ayVar.h.setText(this.a.getString(com.baidu.tieba.x.attention));
                    }
                    ayVar.g.setBackgroundDrawable(null);
                    return;
                }
                return;
            }
            az azVar = (az) view.getTag();
            if (azVar != null) {
                if (this.d.getmDataType() == 1) {
                    com.baidu.tbadk.core.util.ay.f(azVar.a, com.baidu.tieba.t.bg_frs_list);
                    com.baidu.tbadk.core.util.ay.a(azVar.c, com.baidu.tieba.r.cp_cont_f, 1);
                    com.baidu.tbadk.core.util.ay.f(azVar.d, com.baidu.tieba.t.btn_person_add);
                    com.baidu.tbadk.core.util.ay.c(azVar.e, com.baidu.tieba.t.icon_person_add);
                    com.baidu.tbadk.core.util.ay.a(azVar.f, com.baidu.tieba.r.cp_cont_g, 1);
                    azVar.f.setText(this.a.getString(com.baidu.tieba.x.addfriend));
                    a((ViewGroup) azVar.b);
                } else if (this.d.getmDataType() == 2) {
                    azVar.c.setVisibility(8);
                    com.baidu.tbadk.core.util.ay.f(azVar.d, com.baidu.tieba.t.btn_pop_news);
                    com.baidu.tbadk.core.util.ay.c(azVar.e, com.baidu.tieba.t.icon_pop_news);
                    com.baidu.tbadk.core.util.ay.a(azVar.f, com.baidu.tieba.r.cp_link_tip_c, 1);
                    azVar.f.setText(this.a.getString(com.baidu.tieba.x.user_info_center_head_viewpager_send_text_name));
                }
                if (this.d != null && this.d.getmModel() != null && this.d.getmModel().k() != null && this.d.getmModel().k().getHave_attention() == 1) {
                    z = true;
                }
                if (z) {
                    com.baidu.tbadk.core.util.ay.f(azVar.g, com.baidu.tieba.t.btn_pop_news);
                    com.baidu.tbadk.core.util.ay.c(azVar.h, com.baidu.tieba.t.icon_pop_cancel_blue);
                    com.baidu.tbadk.core.util.ay.a(azVar.i, com.baidu.tieba.r.cp_link_tip_c, 1);
                    azVar.i.setText(this.a.getString(com.baidu.tieba.x.attention_cancel));
                    return;
                }
                com.baidu.tbadk.core.util.ay.f(azVar.g, com.baidu.tieba.t.btn_pop_news);
                com.baidu.tbadk.core.util.ay.c(azVar.h, com.baidu.tieba.t.icon_pop_add_blue);
                com.baidu.tbadk.core.util.ay.a(azVar.i, com.baidu.tieba.r.cp_link_tip_c, 1);
                azVar.i.setText(this.a.getString(com.baidu.tieba.x.attention));
            }
        }
    }
}
