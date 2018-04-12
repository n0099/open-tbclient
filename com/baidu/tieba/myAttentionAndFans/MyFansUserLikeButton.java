package com.baidu.tieba.myAttentionAndFans;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tieba.d;
import com.baidu.tieba.view.a;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class MyFansUserLikeButton extends CommonUserLikeButton {
    private int currentPage;
    private com.baidu.tieba.person.e eSk;
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
    public void aQ(boolean z) {
    }

    @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton, com.baidu.tbadk.core.view.userLike.b
    public void d(boolean z, int i) {
        this.aqC = z;
        if (z) {
            switch (i) {
                case 1:
                    setTextSize(0, l.e(getContext(), d.e.ds26));
                    setText(this.aqA);
                    break;
                case 2:
                    setTextSize(0, l.e(getContext(), d.e.ds24));
                    setText(d.k.each_concerned);
                    break;
                default:
                    setTextSize(0, l.e(getContext(), d.e.ds26));
                    setText(this.aqA);
                    break;
            }
            setPadding(0, 0, 0, 0);
        } else {
            setTextSize(0, l.e(getContext(), d.e.ds26));
            setText(this.aqB);
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
        if (this.aqC) {
            setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            ak.h(this, d.C0126d.btn_forum_focus_gray_color);
            ak.i(this, d.f.btn_transparent_gray_border);
            return;
        }
        setCompoundDrawablesWithIntrinsicBounds(ak.getDrawable(d.f.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
        ak.h(this, d.C0126d.btn_forum_focus_color);
        ak.i(this, d.f.btn_transparent_focus_border_bg);
    }

    public void setContext(com.baidu.adp.base.e eVar) {
        this.mContext = eVar;
    }

    @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton, com.baidu.tbadk.core.view.userLike.b
    public void c(final View.OnClickListener onClickListener) {
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.MyFansUserLikeButton.1
            @Override // android.view.View.OnClickListener
            public void onClick(final View view2) {
                if (MyFansUserLikeButton.this.currentPage != 1) {
                    if (MyFansUserLikeButton.this.currentPage == 2) {
                        TiebaStatic.log(new al("c12605").r("obj_locate", MyFansUserLikeButton.this.aqC ? 3 : 2).ac("obj_param1", MyFansUserLikeButton.this.uid));
                    }
                } else {
                    TiebaStatic.log(new al("c12772").ac("obj_locate", MyFansUserLikeButton.this.aqC ? "3" : "2").ac("obj_param1", MyFansUserLikeButton.this.uid));
                }
                if (MyFansUserLikeButton.this.aqC) {
                    if (MyFansUserLikeButton.this.mContext != null) {
                        if (MyFansUserLikeButton.this.eSk == null) {
                            com.baidu.tieba.view.a aVar = new com.baidu.tieba.view.a(MyFansUserLikeButton.this.mContext.getContext());
                            aVar.setTitleText(MyFansUserLikeButton.this.mContext.getString(d.k.confirm_unlike));
                            ArrayList arrayList = new ArrayList();
                            a.C0232a c0232a = new a.C0232a(MyFansUserLikeButton.this.mContext.getString(d.k.confirm), aVar);
                            c0232a.a(new a.c() { // from class: com.baidu.tieba.myAttentionAndFans.MyFansUserLikeButton.1.1
                                @Override // com.baidu.tieba.view.a.c
                                public void onClick() {
                                    if (onClickListener != null) {
                                        onClickListener.onClick(view2);
                                        if (MyFansUserLikeButton.this.currentPage != 1) {
                                            if (MyFansUserLikeButton.this.currentPage == 2) {
                                                TiebaStatic.log(new al("C12603").ac("obj_param1", MyFansUserLikeButton.this.uid));
                                            }
                                        } else {
                                            TiebaStatic.log(new al("c12773").ac("obj_param1", MyFansUserLikeButton.this.uid));
                                        }
                                        MyFansUserLikeButton.this.eSk.dismiss();
                                    }
                                }
                            });
                            arrayList.add(c0232a);
                            aVar.a(new a.b() { // from class: com.baidu.tieba.myAttentionAndFans.MyFansUserLikeButton.1.2
                                @Override // com.baidu.tieba.view.a.b
                                public void onClick() {
                                    if (MyFansUserLikeButton.this.eSk != null) {
                                        MyFansUserLikeButton.this.eSk.dismiss();
                                    }
                                }
                            });
                            aVar.dF(arrayList);
                            MyFansUserLikeButton.this.eSk = new com.baidu.tieba.person.e(MyFansUserLikeButton.this.mContext.getPageActivity(), aVar.bAc());
                            MyFansUserLikeButton.this.eSk.aq(0.7f);
                        }
                        MyFansUserLikeButton.this.eSk.show();
                        return;
                    }
                    return;
                }
                onClickListener.onClick(view2);
            }
        });
    }
}
