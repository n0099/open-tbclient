package com.baidu.tieba.myAttentionAndFans;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tieba.d;
import com.baidu.tieba.view.c;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class MyFansUserLikeButton extends CommonUserLikeButton {
    private int bNI;
    private com.baidu.tieba.person.e fxk;
    private com.baidu.adp.base.e mContext;
    private String uid;

    public MyFansUserLikeButton(Context context) {
        super(context);
        this.bNI = 1;
    }

    public MyFansUserLikeButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bNI = 1;
    }

    public MyFansUserLikeButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bNI = 1;
    }

    @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton
    public void bz(boolean z) {
    }

    @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton, com.baidu.tbadk.core.view.userLike.b
    public void f(boolean z, int i) {
        this.bfk = z;
        if (z) {
            switch (i) {
                case 1:
                    setTextSize(0, l.t(getContext(), d.e.ds26));
                    setText(this.bfi);
                    break;
                case 2:
                    setTextSize(0, l.t(getContext(), d.e.ds24));
                    setText(d.j.each_concerned);
                    break;
                default:
                    setTextSize(0, l.t(getContext(), d.e.ds26));
                    setText(this.bfi);
                    break;
            }
            setPadding(0, 0, 0, 0);
        } else {
            setTextSize(0, l.t(getContext(), d.e.ds26));
            setText(this.bfj);
            setPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds18), 0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds10), 0);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void Y(int i, String str) {
        this.bNI = i;
        this.uid = str;
    }

    @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton
    public void onChangeSkinType(int i) {
        if (this.bfk) {
            setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            aj.r(this, d.C0141d.btn_forum_focus_gray_color);
            aj.s(this, d.f.btn_transparent_gray_border);
            return;
        }
        setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.f.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
        aj.r(this, d.C0141d.btn_forum_focus_color);
        aj.s(this, d.f.btn_transparent_focus_border_bg);
    }

    public void setContext(com.baidu.adp.base.e eVar) {
        this.mContext = eVar;
    }

    @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton, com.baidu.tbadk.core.view.userLike.b
    public void c(final View.OnClickListener onClickListener) {
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.MyFansUserLikeButton.1
            @Override // android.view.View.OnClickListener
            public void onClick(final View view) {
                if (MyFansUserLikeButton.this.bNI != 1) {
                    if (MyFansUserLikeButton.this.bNI == 2) {
                        TiebaStatic.log(new ak("c12605").s("obj_locate", MyFansUserLikeButton.this.bfk ? 3 : 2).ab("obj_param1", MyFansUserLikeButton.this.uid));
                    }
                } else {
                    TiebaStatic.log(new ak("c12772").ab("obj_locate", MyFansUserLikeButton.this.bfk ? "3" : "2").ab("obj_param1", MyFansUserLikeButton.this.uid));
                }
                if (MyFansUserLikeButton.this.bfk) {
                    if (MyFansUserLikeButton.this.mContext != null) {
                        if (MyFansUserLikeButton.this.fxk == null) {
                            com.baidu.tieba.view.c cVar = new com.baidu.tieba.view.c(MyFansUserLikeButton.this.mContext.getContext());
                            cVar.setTitleText(MyFansUserLikeButton.this.mContext.getString(d.j.confirm_unlike));
                            ArrayList arrayList = new ArrayList();
                            c.a aVar = new c.a(MyFansUserLikeButton.this.mContext.getString(d.j.confirm), cVar);
                            aVar.a(new c.InterfaceC0251c() { // from class: com.baidu.tieba.myAttentionAndFans.MyFansUserLikeButton.1.1
                                @Override // com.baidu.tieba.view.c.InterfaceC0251c
                                public void onClick() {
                                    if (onClickListener != null) {
                                        onClickListener.onClick(view);
                                        if (MyFansUserLikeButton.this.bNI != 1) {
                                            if (MyFansUserLikeButton.this.bNI == 2) {
                                                TiebaStatic.log(new ak("C12603").ab("obj_param1", MyFansUserLikeButton.this.uid));
                                            }
                                        } else {
                                            TiebaStatic.log(new ak("c12773").ab("obj_param1", MyFansUserLikeButton.this.uid));
                                        }
                                        MyFansUserLikeButton.this.fxk.dismiss();
                                    }
                                }
                            });
                            arrayList.add(aVar);
                            cVar.a(new c.b() { // from class: com.baidu.tieba.myAttentionAndFans.MyFansUserLikeButton.1.2
                                @Override // com.baidu.tieba.view.c.b
                                public void onClick() {
                                    if (MyFansUserLikeButton.this.fxk != null) {
                                        MyFansUserLikeButton.this.fxk.dismiss();
                                    }
                                }
                            });
                            cVar.dO(arrayList);
                            MyFansUserLikeButton.this.fxk = new com.baidu.tieba.person.e(MyFansUserLikeButton.this.mContext.getPageActivity(), cVar.bEK());
                            MyFansUserLikeButton.this.fxk.aC(0.7f);
                        }
                        MyFansUserLikeButton.this.fxk.show();
                        return;
                    }
                    return;
                }
                onClickListener.onClick(view);
            }
        });
    }
}
