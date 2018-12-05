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
    private e fFU;
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
    public void bK(boolean z) {
    }

    @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton, com.baidu.tbadk.core.view.userLike.b
    public void d(boolean z, int i) {
        this.aLi = z;
        if (z) {
            switch (i) {
                case 1:
                    setTextSize(0, l.h(getContext(), e.C0210e.ds26));
                    setText(this.aLg);
                    break;
                case 2:
                    setTextSize(0, l.h(getContext(), e.C0210e.ds24));
                    setText(e.j.each_concerned);
                    break;
                default:
                    setTextSize(0, l.h(getContext(), e.C0210e.ds26));
                    setText(this.aLg);
                    break;
            }
            setPadding(0, 0, 0, 0);
        } else {
            setTextSize(0, l.h(getContext(), e.C0210e.ds26));
            setText(this.aLh);
            setPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0210e.ds18), 0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0210e.ds10), 0);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setStatsParams(int i, String str) {
        this.currentPage = i;
        this.uid = str;
    }

    @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton
    public void onChangeSkinType(int i) {
        if (this.aLi) {
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
    public void d(final View.OnClickListener onClickListener) {
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.MyFansUserLikeButton.1
            @Override // android.view.View.OnClickListener
            public void onClick(final View view) {
                if (MyFansUserLikeButton.this.currentPage != 1) {
                    if (MyFansUserLikeButton.this.currentPage == 2) {
                        TiebaStatic.log(new am("c12605").x("obj_locate", MyFansUserLikeButton.this.aLi ? 3 : 2).aA("obj_param1", MyFansUserLikeButton.this.uid));
                    }
                } else {
                    TiebaStatic.log(new am("c12772").aA("obj_locate", MyFansUserLikeButton.this.aLi ? "3" : "2").aA("obj_param1", MyFansUserLikeButton.this.uid));
                }
                if (MyFansUserLikeButton.this.aLi) {
                    if (MyFansUserLikeButton.this.mContext != null) {
                        if (MyFansUserLikeButton.this.fFU == null) {
                            com.baidu.tieba.view.a aVar = new com.baidu.tieba.view.a(MyFansUserLikeButton.this.mContext.getContext());
                            aVar.setTitleText(MyFansUserLikeButton.this.mContext.getString(e.j.confirm_unlike));
                            ArrayList arrayList = new ArrayList();
                            a.C0334a c0334a = new a.C0334a(MyFansUserLikeButton.this.mContext.getString(e.j.confirm), aVar);
                            c0334a.a(new a.c() { // from class: com.baidu.tieba.myAttentionAndFans.MyFansUserLikeButton.1.1
                                @Override // com.baidu.tieba.view.a.c
                                public void onClick() {
                                    if (onClickListener != null) {
                                        onClickListener.onClick(view);
                                        if (MyFansUserLikeButton.this.currentPage != 1) {
                                            if (MyFansUserLikeButton.this.currentPage == 2) {
                                                TiebaStatic.log(new am("C12603").aA("obj_param1", MyFansUserLikeButton.this.uid));
                                            }
                                        } else {
                                            TiebaStatic.log(new am("c12773").aA("obj_param1", MyFansUserLikeButton.this.uid));
                                        }
                                        g.b(MyFansUserLikeButton.this.fFU, MyFansUserLikeButton.this.mContext);
                                    }
                                }
                            });
                            arrayList.add(c0334a);
                            aVar.a(new a.b() { // from class: com.baidu.tieba.myAttentionAndFans.MyFansUserLikeButton.1.2
                                @Override // com.baidu.tieba.view.a.b
                                public void onClick() {
                                    if (MyFansUserLikeButton.this.fFU != null) {
                                        g.b(MyFansUserLikeButton.this.fFU, MyFansUserLikeButton.this.mContext);
                                    }
                                }
                            });
                            aVar.ed(arrayList);
                            MyFansUserLikeButton.this.fFU = new com.baidu.tieba.person.e(MyFansUserLikeButton.this.mContext.getPageActivity(), aVar.bLZ());
                            MyFansUserLikeButton.this.fFU.ax(0.7f);
                        }
                        g.a(MyFansUserLikeButton.this.fFU, MyFansUserLikeButton.this.mContext);
                        return;
                    }
                    return;
                }
                onClickListener.onClick(view);
            }
        });
    }
}
