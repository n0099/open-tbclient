package com.baidu.tieba.myAttentionAndFans;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.adp.lib.g.g;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tieba.e;
import com.baidu.tieba.person.e;
import com.baidu.tieba.view.a;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class MyFansUserLikeButton extends CommonUserLikeButton {
    private int currentPage;
    private e fxH;
    private com.baidu.adp.base.e mContext;
    private String uid;

    public MyFansUserLikeButton(Context context) {
        super(context);
        this.currentPage = 1;
    }

    public MyFansUserLikeButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.currentPage = 1;
    }

    public MyFansUserLikeButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.currentPage = 1;
    }

    @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton
    public void bs(boolean z) {
    }

    @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton, com.baidu.tbadk.core.view.userLike.b
    public void d(boolean z, int i) {
        this.aGS = z;
        if (z) {
            switch (i) {
                case 1:
                    setTextSize(0, l.h(getContext(), e.C0175e.ds26));
                    setText(this.aGQ);
                    break;
                case 2:
                    setTextSize(0, l.h(getContext(), e.C0175e.ds24));
                    setText(e.j.each_concerned);
                    break;
                default:
                    setTextSize(0, l.h(getContext(), e.C0175e.ds26));
                    setText(this.aGQ);
                    break;
            }
            setPadding(0, 0, 0, 0);
        } else {
            setTextSize(0, l.h(getContext(), e.C0175e.ds26));
            setText(this.aGR);
            setPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0175e.ds18), 0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0175e.ds10), 0);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setStatsParams(int i, String str) {
        this.currentPage = i;
        this.uid = str;
    }

    @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton
    public void onChangeSkinType(int i) {
        if (this.aGS) {
            setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            al.h(this, e.d.btn_forum_focus_gray_color);
            al.i(this, e.f.btn_transparent_gray_border);
            return;
        }
        setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(e.f.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
        al.h(this, e.d.btn_forum_focus_color);
        al.i(this, e.f.btn_transparent_focus_border_bg);
    }

    public void setContext(com.baidu.adp.base.e eVar) {
        this.mContext = eVar;
    }

    @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton, com.baidu.tbadk.core.view.userLike.b
    public void c(final View.OnClickListener onClickListener) {
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.MyFansUserLikeButton.1
            @Override // android.view.View.OnClickListener
            public void onClick(final View view) {
                if (MyFansUserLikeButton.this.currentPage != 1) {
                    if (MyFansUserLikeButton.this.currentPage == 2) {
                        TiebaStatic.log(new am("c12605").x("obj_locate", MyFansUserLikeButton.this.aGS ? 3 : 2).ax("obj_param1", MyFansUserLikeButton.this.uid));
                    }
                } else {
                    TiebaStatic.log(new am("c12772").ax("obj_locate", MyFansUserLikeButton.this.aGS ? "3" : "2").ax("obj_param1", MyFansUserLikeButton.this.uid));
                }
                if (MyFansUserLikeButton.this.aGS) {
                    if (MyFansUserLikeButton.this.mContext != null) {
                        if (MyFansUserLikeButton.this.fxH == null) {
                            com.baidu.tieba.view.a aVar = new com.baidu.tieba.view.a(MyFansUserLikeButton.this.mContext.getContext());
                            aVar.setTitleText(MyFansUserLikeButton.this.mContext.getString(e.j.confirm_unlike));
                            ArrayList arrayList = new ArrayList();
                            a.C0292a c0292a = new a.C0292a(MyFansUserLikeButton.this.mContext.getString(e.j.confirm), aVar);
                            c0292a.a(new a.c() { // from class: com.baidu.tieba.myAttentionAndFans.MyFansUserLikeButton.1.1
                                @Override // com.baidu.tieba.view.a.c
                                public void onClick() {
                                    if (onClickListener != null) {
                                        onClickListener.onClick(view);
                                        if (MyFansUserLikeButton.this.currentPage != 1) {
                                            if (MyFansUserLikeButton.this.currentPage == 2) {
                                                TiebaStatic.log(new am("C12603").ax("obj_param1", MyFansUserLikeButton.this.uid));
                                            }
                                        } else {
                                            TiebaStatic.log(new am("c12773").ax("obj_param1", MyFansUserLikeButton.this.uid));
                                        }
                                        g.b(MyFansUserLikeButton.this.fxH, MyFansUserLikeButton.this.mContext);
                                    }
                                }
                            });
                            arrayList.add(c0292a);
                            aVar.a(new a.b() { // from class: com.baidu.tieba.myAttentionAndFans.MyFansUserLikeButton.1.2
                                @Override // com.baidu.tieba.view.a.b
                                public void onClick() {
                                    if (MyFansUserLikeButton.this.fxH != null) {
                                        g.b(MyFansUserLikeButton.this.fxH, MyFansUserLikeButton.this.mContext);
                                    }
                                }
                            });
                            aVar.eb(arrayList);
                            MyFansUserLikeButton.this.fxH = new com.baidu.tieba.person.e(MyFansUserLikeButton.this.mContext.getPageActivity(), aVar.bKv());
                            MyFansUserLikeButton.this.fxH.av(0.7f);
                        }
                        g.a(MyFansUserLikeButton.this.fxH, MyFansUserLikeButton.this.mContext);
                        return;
                    }
                    return;
                }
                onClickListener.onClick(view);
            }
        });
    }
}
