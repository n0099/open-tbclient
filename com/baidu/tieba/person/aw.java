package com.baidu.tieba.person;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes.dex */
public class aw {
    private final Context a;
    private final View.OnClickListener b = new ax(this);
    private BaseFragmentActivity c;
    private PersonRelationCardData d;
    private String e;
    private int f;

    public aw(Context context, PersonRelationCardData personRelationCardData) {
        this.a = context;
        this.d = personRelationCardData;
        this.c = (BaseFragmentActivity) this.a;
    }

    public View a() {
        ay ayVar = new ay(this);
        View inflate = ((LayoutInflater) this.a.getSystemService("layout_inflater")).inflate(com.baidu.tieba.w.person_center_relation_card_view, (ViewGroup) null);
        ayVar.a = (LinearLayout) inflate.findViewById(com.baidu.tieba.v.relationcardcontent);
        ayVar.b = (RelativeLayout) inflate.findViewById(com.baidu.tieba.v.relationcarddisrelativelayout);
        ayVar.c = (RelativeLayout) inflate.findViewById(com.baidu.tieba.v.relationcardlikerelativelayout);
        ayVar.d = (RelativeLayout) inflate.findViewById(com.baidu.tieba.v.relationcardfriendrelativelayout);
        ayVar.e = (RelativeLayout) inflate.findViewById(com.baidu.tieba.v.relationcardgrouprelativelayout);
        ayVar.f = (TextView) inflate.findViewById(com.baidu.tieba.v.relationcarddistextview);
        ayVar.g = (TextView) inflate.findViewById(com.baidu.tieba.v.relationcardliketextview);
        ayVar.h = (TextView) inflate.findViewById(com.baidu.tieba.v.relationcardfriendtextview);
        ayVar.i = (TextView) inflate.findViewById(com.baidu.tieba.v.relationcardgrouptextview);
        ayVar.j = (TextView) inflate.findViewById(com.baidu.tieba.v.relationcardlikearrow);
        ayVar.k = (TextView) inflate.findViewById(com.baidu.tieba.v.relationcardfriendarrow);
        ayVar.d.setOnClickListener(this.b);
        ayVar.e.setOnClickListener(this.b);
        ayVar.c.setOnClickListener(this.b);
        inflate.setTag(ayVar);
        return inflate;
    }

    public void a(View view) {
        ay ayVar;
        if (view.getTag() != null && (ayVar = (ay) view.getTag()) != null) {
            if (TextUtils.isEmpty(this.d.getDistance())) {
                ayVar.b.setVisibility(8);
            } else {
                ayVar.b.setVisibility(0);
                ayVar.f.setText(this.d.getDistance());
            }
            if (TextUtils.isEmpty(this.d.getCommonLike())) {
                ayVar.c.setVisibility(8);
            } else {
                ayVar.c.setVisibility(0);
                ayVar.g.setText(this.d.getCommonLike());
            }
            if (TextUtils.isEmpty(this.d.getCommonFriend())) {
                ayVar.d.setVisibility(8);
            } else {
                ayVar.d.setVisibility(0);
                ayVar.h.setText(this.d.getCommonFriend());
            }
            if (TextUtils.isEmpty(this.d.getCommonGroup())) {
                ayVar.e.setVisibility(8);
            } else {
                ayVar.e.setVisibility(0);
                ayVar.i.setText(this.d.getCommonGroup());
            }
            this.e = this.d.getuId();
            this.f = this.d.getSex();
            this.c.c().a(TbadkApplication.m252getInst().getSkinType() == 1);
            this.c.c().a((View) ayVar.a);
        }
    }
}
