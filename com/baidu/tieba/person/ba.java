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
public class ba {
    private final Context a;
    private final View.OnClickListener b = new bb(this);
    private BaseFragmentActivity c;
    private PersonRelationCardData d;
    private String e;
    private int f;

    public ba(Context context, PersonRelationCardData personRelationCardData) {
        this.a = context;
        this.d = personRelationCardData;
        this.c = (BaseFragmentActivity) this.a;
    }

    public View a() {
        bc bcVar = new bc(this);
        View inflate = ((LayoutInflater) this.a.getSystemService("layout_inflater")).inflate(com.baidu.tieba.v.person_center_relation_card_view, (ViewGroup) null);
        bcVar.a = (LinearLayout) inflate.findViewById(com.baidu.tieba.u.relationcardcontent);
        bcVar.b = (RelativeLayout) inflate.findViewById(com.baidu.tieba.u.relationcarddisrelativelayout);
        bcVar.c = (RelativeLayout) inflate.findViewById(com.baidu.tieba.u.relationcardlikerelativelayout);
        bcVar.d = (RelativeLayout) inflate.findViewById(com.baidu.tieba.u.relationcardfriendrelativelayout);
        bcVar.e = (RelativeLayout) inflate.findViewById(com.baidu.tieba.u.relationcardgrouprelativelayout);
        bcVar.f = (TextView) inflate.findViewById(com.baidu.tieba.u.relationcarddistextview);
        bcVar.g = (TextView) inflate.findViewById(com.baidu.tieba.u.relationcardliketextview);
        bcVar.h = (TextView) inflate.findViewById(com.baidu.tieba.u.relationcardfriendtextview);
        bcVar.i = (TextView) inflate.findViewById(com.baidu.tieba.u.relationcardgrouptextview);
        bcVar.j = (TextView) inflate.findViewById(com.baidu.tieba.u.relationcardlikearrow);
        bcVar.k = (TextView) inflate.findViewById(com.baidu.tieba.u.relationcardfriendarrow);
        bcVar.d.setOnClickListener(this.b);
        bcVar.e.setOnClickListener(this.b);
        bcVar.c.setOnClickListener(this.b);
        inflate.setTag(bcVar);
        return inflate;
    }

    public void a(View view) {
        bc bcVar;
        if (view.getTag() != null && (bcVar = (bc) view.getTag()) != null) {
            if (TextUtils.isEmpty(this.d.getDistance())) {
                bcVar.b.setVisibility(8);
            } else {
                bcVar.b.setVisibility(0);
                bcVar.f.setText(this.d.getDistance());
            }
            if (TextUtils.isEmpty(this.d.getCommonLike())) {
                bcVar.c.setVisibility(8);
            } else {
                bcVar.c.setVisibility(0);
                bcVar.g.setText(this.d.getCommonLike());
            }
            if (TextUtils.isEmpty(this.d.getCommonFriend())) {
                bcVar.d.setVisibility(8);
            } else {
                bcVar.d.setVisibility(0);
                bcVar.h.setText(this.d.getCommonFriend());
            }
            if (TextUtils.isEmpty(this.d.getCommonGroup())) {
                bcVar.e.setVisibility(8);
            } else {
                bcVar.e.setVisibility(0);
                bcVar.i.setText(this.d.getCommonGroup());
            }
            this.e = this.d.getuId();
            this.f = this.d.getSex();
            this.c.c().a(TbadkApplication.m252getInst().getSkinType() == 1);
            this.c.c().a((View) bcVar.a);
        }
    }
}
