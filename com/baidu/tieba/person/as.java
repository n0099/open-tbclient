package com.baidu.tieba.person;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
public class as {
    private Context a;
    private BaseFragmentActivity b;
    private View.OnClickListener c = new at(this);
    private PersonCenterListTopData d;

    public as(Context context, PersonCenterListTopData personCenterListTopData) {
        this.a = context;
        this.b = (BaseFragmentActivity) this.a;
        this.d = personCenterListTopData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        TiebaStatic.eventStat(this.a, "enter_chat", "personclick", 1, new Object[0]);
        try {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new com.baidu.tbadk.core.atomData.bc(this.a, Long.parseLong(this.d.getmModel().j().getUserId()), this.d.getmModel().j().getUserName(), this.d.getmModel().j().getPortrait(), this.d.getmModel().j().getSex())));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public View a() {
        LayoutInflater layoutInflater = (LayoutInflater) this.a.getSystemService("layout_inflater");
        if (this.d.getmDataType() == 3) {
            au auVar = new au(this);
            View inflate = layoutInflater.inflate(com.baidu.tieba.w.person_center_accpet_card_view, (ViewGroup) null);
            auVar.a = (LinearLayout) inflate.findViewById(com.baidu.tieba.v.viewcontent);
            auVar.b = (LinearLayout) inflate.findViewById(com.baidu.tieba.v.topbuttonview_content);
            auVar.c = (TextView) inflate.findViewById(com.baidu.tieba.v.applymessage_textview);
            auVar.b.setOnClickListener(this.c);
            inflate.setTag(auVar);
            return inflate;
        }
        av avVar = new av(this);
        View inflate2 = layoutInflater.inflate(com.baidu.tieba.w.person_center_topbutton_view, (ViewGroup) null);
        avVar.a = (LinearLayout) inflate2.findViewById(com.baidu.tieba.v.topbuttonview_content);
        avVar.b = (ImageView) inflate2.findViewById(com.baidu.tieba.v.tagiconimageview);
        avVar.c = (TextView) inflate2.findViewById(com.baidu.tieba.v.tagtextview);
        avVar.a.setOnClickListener(this.c);
        inflate2.setTag(avVar);
        return inflate2;
    }

    public void a(View view) {
        if (view.getTag() != null) {
            if (this.d.getmDataType() == 3) {
                au auVar = (au) view.getTag();
                if (auVar != null) {
                    if (this.d.getmModel().a().h() != null) {
                        int size = this.d.getmModel().a().h().size();
                        if (size == 0) {
                            auVar.c.setVisibility(8);
                        } else {
                            String str = this.d.getmModel().a().h().get(size - 1).c;
                            if (!TextUtils.isEmpty(str)) {
                                if (this.d.getmModel().j() != null) {
                                    String userName = this.d.getmModel().j().getUserName();
                                    if (!TextUtils.isEmpty(userName)) {
                                        auVar.c.setText(String.valueOf(userName) + ":" + str);
                                    } else {
                                        auVar.c.setText(str);
                                    }
                                } else {
                                    auVar.c.setText(str);
                                }
                            } else {
                                auVar.c.setVisibility(8);
                            }
                        }
                    } else {
                        auVar.c.setVisibility(8);
                    }
                    this.b.c().a(TbadkApplication.m252getInst().getSkinType() == 1);
                    this.b.c().a((View) auVar.a);
                    return;
                }
                return;
            }
            av avVar = (av) view.getTag();
            if (avVar != null) {
                if (this.d.getmDataType() == 1) {
                    com.baidu.tbadk.core.util.bk.f(avVar.a, com.baidu.tieba.u.btn_person_add);
                    com.baidu.tbadk.core.util.bk.c(avVar.b, com.baidu.tieba.u.icon_person_add);
                    com.baidu.tbadk.core.util.bk.a(avVar.c, com.baidu.tieba.s.cp_cont_g, 1);
                    avVar.c.setText(this.a.getString(com.baidu.tieba.y.addfriend));
                } else if (this.d.getmDataType() == 2) {
                    com.baidu.tbadk.core.util.bk.f(avVar.a, com.baidu.tieba.u.btn_pop_news);
                    com.baidu.tbadk.core.util.bk.c(avVar.b, com.baidu.tieba.u.icon_pop_news);
                    com.baidu.tbadk.core.util.bk.a(avVar.c, com.baidu.tieba.s.cp_link_tip_c, 1);
                    avVar.c.setText(this.a.getString(com.baidu.tieba.y.user_info_center_head_viewpager_send_text_name));
                }
            }
        }
    }
}
