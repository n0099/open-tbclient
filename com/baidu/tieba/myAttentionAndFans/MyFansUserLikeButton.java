package com.baidu.tieba.myAttentionAndFans;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.adp.lib.g.g;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tieba.d;
import com.baidu.tieba.person.e;
import com.baidu.tieba.view.a;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class MyFansUserLikeButton extends CommonUserLikeButton {
    private int bhK;
    private e fiL;
    private com.baidu.adp.base.e mContext;
    private String uid;

    public MyFansUserLikeButton(Context context) {
        super(context);
        this.bhK = 1;
    }

    public MyFansUserLikeButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bhK = 1;
    }

    public MyFansUserLikeButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bhK = 1;
    }

    @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton
    public void aV(boolean z) {
    }

    @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton, com.baidu.tbadk.core.view.userLike.b
    public void d(boolean z, int i) {
        this.azn = z;
        if (z) {
            switch (i) {
                case 1:
                    setTextSize(0, l.f(getContext(), d.e.ds26));
                    setText(this.azl);
                    break;
                case 2:
                    setTextSize(0, l.f(getContext(), d.e.ds24));
                    setText(d.j.each_concerned);
                    break;
                default:
                    setTextSize(0, l.f(getContext(), d.e.ds26));
                    setText(this.azl);
                    break;
            }
            setPadding(0, 0, 0, 0);
        } else {
            setTextSize(0, l.f(getContext(), d.e.ds26));
            setText(this.azm);
            setPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds18), 0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds10), 0);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setStatsParams(int i, String str) {
        this.bhK = i;
        this.uid = str;
    }

    @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton
    public void onChangeSkinType(int i) {
        if (this.azn) {
            setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            am.h(this, d.C0140d.btn_forum_focus_gray_color);
            am.i(this, d.f.btn_transparent_gray_border);
            return;
        }
        setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(d.f.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
        am.h(this, d.C0140d.btn_forum_focus_color);
        am.i(this, d.f.btn_transparent_focus_border_bg);
    }

    public void setContext(com.baidu.adp.base.e eVar) {
        this.mContext = eVar;
    }

    @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton, com.baidu.tbadk.core.view.userLike.b
    public void c(final View.OnClickListener onClickListener) {
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.MyFansUserLikeButton.1
            @Override // android.view.View.OnClickListener
            public void onClick(final View view) {
                if (MyFansUserLikeButton.this.bhK != 1) {
                    if (MyFansUserLikeButton.this.bhK == 2) {
                        TiebaStatic.log(new an("c12605").r("obj_locate", MyFansUserLikeButton.this.azn ? 3 : 2).af("obj_param1", MyFansUserLikeButton.this.uid));
                    }
                } else {
                    TiebaStatic.log(new an("c12772").af("obj_locate", MyFansUserLikeButton.this.azn ? "3" : "2").af("obj_param1", MyFansUserLikeButton.this.uid));
                }
                if (MyFansUserLikeButton.this.azn) {
                    if (MyFansUserLikeButton.this.mContext != null) {
                        if (MyFansUserLikeButton.this.fiL == null) {
                            com.baidu.tieba.view.a aVar = new com.baidu.tieba.view.a(MyFansUserLikeButton.this.mContext.getContext());
                            aVar.setTitleText(MyFansUserLikeButton.this.mContext.getString(d.j.confirm_unlike));
                            ArrayList arrayList = new ArrayList();
                            a.C0251a c0251a = new a.C0251a(MyFansUserLikeButton.this.mContext.getString(d.j.confirm), aVar);
                            c0251a.a(new a.c() { // from class: com.baidu.tieba.myAttentionAndFans.MyFansUserLikeButton.1.1
                                @Override // com.baidu.tieba.view.a.c
                                public void onClick() {
                                    if (onClickListener != null) {
                                        onClickListener.onClick(view);
                                        if (MyFansUserLikeButton.this.bhK != 1) {
                                            if (MyFansUserLikeButton.this.bhK == 2) {
                                                TiebaStatic.log(new an("C12603").af("obj_param1", MyFansUserLikeButton.this.uid));
                                            }
                                        } else {
                                            TiebaStatic.log(new an("c12773").af("obj_param1", MyFansUserLikeButton.this.uid));
                                        }
                                        g.b(MyFansUserLikeButton.this.fiL, MyFansUserLikeButton.this.mContext);
                                    }
                                }
                            });
                            arrayList.add(c0251a);
                            aVar.a(new a.b() { // from class: com.baidu.tieba.myAttentionAndFans.MyFansUserLikeButton.1.2
                                @Override // com.baidu.tieba.view.a.b
                                public void onClick() {
                                    if (MyFansUserLikeButton.this.fiL != null) {
                                        g.b(MyFansUserLikeButton.this.fiL, MyFansUserLikeButton.this.mContext);
                                    }
                                }
                            });
                            aVar.dM(arrayList);
                            MyFansUserLikeButton.this.fiL = new e(MyFansUserLikeButton.this.mContext.getPageActivity(), aVar.bEq());
                            MyFansUserLikeButton.this.fiL.aB(0.7f);
                        }
                        g.a(MyFansUserLikeButton.this.fiL, MyFansUserLikeButton.this.mContext);
                        return;
                    }
                    return;
                }
                onClickListener.onClick(view);
            }
        });
    }
}
