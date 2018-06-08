package com.baidu.tieba.myAttentionAndFans;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tieba.d;
import com.baidu.tieba.view.a;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class MyFansUserLikeButton extends CommonUserLikeButton {
    private int currentPage;
    private com.baidu.tieba.person.e feG;
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
    public void aU(boolean z) {
    }

    @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton, com.baidu.tbadk.core.view.userLike.b
    public void d(boolean z, int i) {
        this.ayJ = z;
        if (z) {
            switch (i) {
                case 1:
                    setTextSize(0, l.e(getContext(), d.e.ds26));
                    setText(this.ayH);
                    break;
                case 2:
                    setTextSize(0, l.e(getContext(), d.e.ds24));
                    setText(d.k.each_concerned);
                    break;
                default:
                    setTextSize(0, l.e(getContext(), d.e.ds26));
                    setText(this.ayH);
                    break;
            }
            setPadding(0, 0, 0, 0);
        } else {
            setTextSize(0, l.e(getContext(), d.e.ds26));
            setText(this.ayI);
            setPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds18), 0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds10), 0);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setStatsParams(int i, String str) {
        this.currentPage = i;
        this.uid = str;
    }

    @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton
    public void onChangeSkinType(int i) {
        if (this.ayJ) {
            setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            al.h(this, d.C0141d.btn_forum_focus_gray_color);
            al.i(this, d.f.btn_transparent_gray_border);
            return;
        }
        setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(d.f.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
        al.h(this, d.C0141d.btn_forum_focus_color);
        al.i(this, d.f.btn_transparent_focus_border_bg);
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
                        TiebaStatic.log(new am("c12605").r("obj_locate", MyFansUserLikeButton.this.ayJ ? 3 : 2).ah("obj_param1", MyFansUserLikeButton.this.uid));
                    }
                } else {
                    TiebaStatic.log(new am("c12772").ah("obj_locate", MyFansUserLikeButton.this.ayJ ? "3" : "2").ah("obj_param1", MyFansUserLikeButton.this.uid));
                }
                if (MyFansUserLikeButton.this.ayJ) {
                    if (MyFansUserLikeButton.this.mContext != null) {
                        if (MyFansUserLikeButton.this.feG == null) {
                            com.baidu.tieba.view.a aVar = new com.baidu.tieba.view.a(MyFansUserLikeButton.this.mContext.getContext());
                            aVar.setTitleText(MyFansUserLikeButton.this.mContext.getString(d.k.confirm_unlike));
                            ArrayList arrayList = new ArrayList();
                            a.C0249a c0249a = new a.C0249a(MyFansUserLikeButton.this.mContext.getString(d.k.confirm), aVar);
                            c0249a.a(new a.c() { // from class: com.baidu.tieba.myAttentionAndFans.MyFansUserLikeButton.1.1
                                @Override // com.baidu.tieba.view.a.c
                                public void onClick() {
                                    if (onClickListener != null) {
                                        onClickListener.onClick(view);
                                        if (MyFansUserLikeButton.this.currentPage != 1) {
                                            if (MyFansUserLikeButton.this.currentPage == 2) {
                                                TiebaStatic.log(new am("C12603").ah("obj_param1", MyFansUserLikeButton.this.uid));
                                            }
                                        } else {
                                            TiebaStatic.log(new am("c12773").ah("obj_param1", MyFansUserLikeButton.this.uid));
                                        }
                                        MyFansUserLikeButton.this.feG.dismiss();
                                    }
                                }
                            });
                            arrayList.add(c0249a);
                            aVar.a(new a.b() { // from class: com.baidu.tieba.myAttentionAndFans.MyFansUserLikeButton.1.2
                                @Override // com.baidu.tieba.view.a.b
                                public void onClick() {
                                    if (MyFansUserLikeButton.this.feG != null) {
                                        MyFansUserLikeButton.this.feG.dismiss();
                                    }
                                }
                            });
                            aVar.dN(arrayList);
                            MyFansUserLikeButton.this.feG = new com.baidu.tieba.person.e(MyFansUserLikeButton.this.mContext.getPageActivity(), aVar.bFf());
                            MyFansUserLikeButton.this.feG.aA(0.7f);
                        }
                        MyFansUserLikeButton.this.feG.show();
                        return;
                    }
                    return;
                }
                onClickListener.onClick(view);
            }
        });
    }
}
