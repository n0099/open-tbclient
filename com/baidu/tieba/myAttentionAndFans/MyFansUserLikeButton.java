package com.baidu.tieba.myAttentionAndFans;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.adp.base.e;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.f;
import com.baidu.tbadk.core.dialog.g;
import com.baidu.tbadk.core.dialog.i;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class MyFansUserLikeButton extends CommonUserLikeButton {
    private int currentPage;
    private g gZS;
    private e mContext;
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
    public void dU(boolean z) {
    }

    @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton, com.baidu.tbadk.core.view.userLike.b
    public void f(boolean z, int i) {
        this.bUn = z;
        if (z) {
            switch (i) {
                case 1:
                    setTextSize(0, l.h(getContext(), d.e.ds26));
                    setText(this.bUl);
                    break;
                case 2:
                    setTextSize(0, l.h(getContext(), d.e.ds24));
                    setText(d.j.each_concerned);
                    break;
                default:
                    setTextSize(0, l.h(getContext(), d.e.ds26));
                    setText(this.bUl);
                    break;
            }
            setPadding(0, 0, 0, 0);
        } else {
            setTextSize(0, l.h(getContext(), d.e.ds26));
            setText(this.bUm);
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
        if (this.bUn) {
            setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            al.j(this, d.C0277d.btn_forum_focus_gray_color);
            al.k(this, d.f.btn_transparent_gray_border);
            return;
        }
        setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(d.f.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
        al.j(this, d.C0277d.btn_forum_focus_color);
        al.k(this, d.f.btn_transparent_focus_border_bg);
    }

    public void setContext(e eVar) {
        this.mContext = eVar;
    }

    @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton, com.baidu.tbadk.core.view.userLike.b
    public void e(final View.OnClickListener onClickListener) {
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.MyFansUserLikeButton.1
            @Override // android.view.View.OnClickListener
            public void onClick(final View view) {
                if (MyFansUserLikeButton.this.currentPage != 1) {
                    if (MyFansUserLikeButton.this.currentPage == 2) {
                        TiebaStatic.log(new am("c12605").T("obj_locate", MyFansUserLikeButton.this.bUn ? 3 : 2).bJ("obj_param1", MyFansUserLikeButton.this.uid));
                    }
                } else {
                    TiebaStatic.log(new am("c12772").bJ("obj_locate", MyFansUserLikeButton.this.bUn ? "3" : "2").bJ("obj_param1", MyFansUserLikeButton.this.uid));
                }
                if (MyFansUserLikeButton.this.bUn) {
                    if (MyFansUserLikeButton.this.mContext != null) {
                        if (MyFansUserLikeButton.this.gZS == null) {
                            i iVar = new i(MyFansUserLikeButton.this.mContext.getContext());
                            iVar.setTitleText(MyFansUserLikeButton.this.mContext.getString(d.j.confirm_unlike));
                            ArrayList arrayList = new ArrayList();
                            f fVar = new f(MyFansUserLikeButton.this.mContext.getString(d.j.confirm), iVar);
                            fVar.a(new i.b() { // from class: com.baidu.tieba.myAttentionAndFans.MyFansUserLikeButton.1.1
                                @Override // com.baidu.tbadk.core.dialog.i.b
                                public void onClick() {
                                    if (onClickListener != null) {
                                        onClickListener.onClick(view);
                                        if (MyFansUserLikeButton.this.currentPage != 1) {
                                            if (MyFansUserLikeButton.this.currentPage == 2) {
                                                TiebaStatic.log(new am("C12603").bJ("obj_param1", MyFansUserLikeButton.this.uid));
                                            }
                                        } else {
                                            TiebaStatic.log(new am("c12773").bJ("obj_param1", MyFansUserLikeButton.this.uid));
                                        }
                                        com.baidu.adp.lib.g.g.b(MyFansUserLikeButton.this.gZS, MyFansUserLikeButton.this.mContext);
                                    }
                                }
                            });
                            arrayList.add(fVar);
                            iVar.a(new i.a() { // from class: com.baidu.tieba.myAttentionAndFans.MyFansUserLikeButton.1.2
                                @Override // com.baidu.tbadk.core.dialog.i.a
                                public void onClick() {
                                    if (MyFansUserLikeButton.this.gZS != null) {
                                        com.baidu.adp.lib.g.g.b(MyFansUserLikeButton.this.gZS, MyFansUserLikeButton.this.mContext);
                                    }
                                }
                            });
                            iVar.P(arrayList);
                            MyFansUserLikeButton.this.gZS = new g(MyFansUserLikeButton.this.mContext, iVar.abk());
                            MyFansUserLikeButton.this.gZS.al(0.7f);
                        }
                        com.baidu.adp.lib.g.g.a(MyFansUserLikeButton.this.gZS, MyFansUserLikeButton.this.mContext);
                        return;
                    }
                    return;
                }
                onClickListener.onClick(view);
            }
        });
    }
}
