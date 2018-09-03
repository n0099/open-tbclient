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
import com.baidu.tieba.f;
import com.baidu.tieba.person.e;
import com.baidu.tieba.view.a;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class MyFansUserLikeButton extends CommonUserLikeButton {
    private int currentPage;
    private e fiF;
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
    public void aW(boolean z) {
    }

    @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton, com.baidu.tbadk.core.view.userLike.b
    public void d(boolean z, int i) {
        this.azk = z;
        if (z) {
            switch (i) {
                case 1:
                    setTextSize(0, l.f(getContext(), f.e.ds26));
                    setText(this.azi);
                    break;
                case 2:
                    setTextSize(0, l.f(getContext(), f.e.ds24));
                    setText(f.j.each_concerned);
                    break;
                default:
                    setTextSize(0, l.f(getContext(), f.e.ds26));
                    setText(this.azi);
                    break;
            }
            setPadding(0, 0, 0, 0);
        } else {
            setTextSize(0, l.f(getContext(), f.e.ds26));
            setText(this.azj);
            setPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(f.e.ds18), 0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(f.e.ds10), 0);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setStatsParams(int i, String str) {
        this.currentPage = i;
        this.uid = str;
    }

    @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton
    public void onChangeSkinType(int i) {
        if (this.azk) {
            setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            am.h(this, f.d.btn_forum_focus_gray_color);
            am.i(this, f.C0146f.btn_transparent_gray_border);
            return;
        }
        setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(f.C0146f.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
        am.h(this, f.d.btn_forum_focus_color);
        am.i(this, f.C0146f.btn_transparent_focus_border_bg);
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
                        TiebaStatic.log(new an("c12605").r("obj_locate", MyFansUserLikeButton.this.azk ? 3 : 2).ae("obj_param1", MyFansUserLikeButton.this.uid));
                    }
                } else {
                    TiebaStatic.log(new an("c12772").ae("obj_locate", MyFansUserLikeButton.this.azk ? "3" : "2").ae("obj_param1", MyFansUserLikeButton.this.uid));
                }
                if (MyFansUserLikeButton.this.azk) {
                    if (MyFansUserLikeButton.this.mContext != null) {
                        if (MyFansUserLikeButton.this.fiF == null) {
                            com.baidu.tieba.view.a aVar = new com.baidu.tieba.view.a(MyFansUserLikeButton.this.mContext.getContext());
                            aVar.setTitleText(MyFansUserLikeButton.this.mContext.getString(f.j.confirm_unlike));
                            ArrayList arrayList = new ArrayList();
                            a.C0251a c0251a = new a.C0251a(MyFansUserLikeButton.this.mContext.getString(f.j.confirm), aVar);
                            c0251a.a(new a.c() { // from class: com.baidu.tieba.myAttentionAndFans.MyFansUserLikeButton.1.1
                                @Override // com.baidu.tieba.view.a.c
                                public void onClick() {
                                    if (onClickListener != null) {
                                        onClickListener.onClick(view);
                                        if (MyFansUserLikeButton.this.currentPage != 1) {
                                            if (MyFansUserLikeButton.this.currentPage == 2) {
                                                TiebaStatic.log(new an("C12603").ae("obj_param1", MyFansUserLikeButton.this.uid));
                                            }
                                        } else {
                                            TiebaStatic.log(new an("c12773").ae("obj_param1", MyFansUserLikeButton.this.uid));
                                        }
                                        g.b(MyFansUserLikeButton.this.fiF, MyFansUserLikeButton.this.mContext);
                                    }
                                }
                            });
                            arrayList.add(c0251a);
                            aVar.a(new a.b() { // from class: com.baidu.tieba.myAttentionAndFans.MyFansUserLikeButton.1.2
                                @Override // com.baidu.tieba.view.a.b
                                public void onClick() {
                                    if (MyFansUserLikeButton.this.fiF != null) {
                                        g.b(MyFansUserLikeButton.this.fiF, MyFansUserLikeButton.this.mContext);
                                    }
                                }
                            });
                            aVar.dM(arrayList);
                            MyFansUserLikeButton.this.fiF = new e(MyFansUserLikeButton.this.mContext.getPageActivity(), aVar.bEs());
                            MyFansUserLikeButton.this.fiF.aA(0.7f);
                        }
                        g.a(MyFansUserLikeButton.this.fiF, MyFansUserLikeButton.this.mContext);
                        return;
                    }
                    return;
                }
                onClickListener.onClick(view);
            }
        });
    }
}
