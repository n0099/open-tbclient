package com.baidu.tieba.myAttentionAndFans;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.adp.base.e;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.g;
import com.baidu.tbadk.core.dialog.i;
import com.baidu.tbadk.core.dialog.k;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes10.dex */
public class MyFansUserLikeButton extends CommonUserLikeButton {
    private int currentPage;
    private i fQK;
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
    public void fV(boolean z) {
    }

    @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton, com.baidu.tbadk.core.view.userLike.b
    public void m(boolean z, int i) {
        this.dkr = z;
        if (z) {
            switch (i) {
                case 1:
                    setTextSize(0, l.getDimens(getContext(), R.dimen.ds26));
                    setText(this.dkp);
                    break;
                case 2:
                    setTextSize(0, l.getDimens(getContext(), R.dimen.ds24));
                    setText(R.string.each_concerned);
                    break;
                default:
                    setTextSize(0, l.getDimens(getContext(), R.dimen.ds26));
                    setText(this.dkp);
                    break;
            }
            setPadding(0, 0, 0, 0);
        } else {
            setTextSize(0, l.getDimens(getContext(), R.dimen.ds26));
            setText(this.dkq);
            setPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds18), 0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds10), 0);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setStatsParams(int i, String str) {
        this.currentPage = i;
        this.uid = str;
    }

    @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton
    public void onChangeSkinType(int i) {
        if (this.dkr) {
            setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            am.setViewTextColor(this, (int) R.color.btn_forum_focus_gray_color);
            am.setBackgroundResource(this, R.drawable.btn_transparent_gray_border);
            return;
        }
        setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
        am.setViewTextColor(this, (int) R.color.btn_forum_focus_color);
        am.setBackgroundResource(this, R.drawable.btn_transparent_focus_border_bg);
    }

    public void setContext(e eVar) {
        this.mContext = eVar;
    }

    @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton, com.baidu.tbadk.core.view.userLike.b
    public void g(final View.OnClickListener onClickListener) {
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.MyFansUserLikeButton.1
            @Override // android.view.View.OnClickListener
            public void onClick(final View view) {
                if (MyFansUserLikeButton.this.currentPage != 1) {
                    if (MyFansUserLikeButton.this.currentPage == 2) {
                        TiebaStatic.log(new an("c12605").X("obj_locate", MyFansUserLikeButton.this.dkr ? 3 : 2).cx("obj_param1", MyFansUserLikeButton.this.uid));
                    }
                } else {
                    TiebaStatic.log(new an("c12772").cx("obj_locate", MyFansUserLikeButton.this.dkr ? "3" : "2").cx("obj_param1", MyFansUserLikeButton.this.uid));
                }
                if (MyFansUserLikeButton.this.dkr) {
                    if (MyFansUserLikeButton.this.mContext != null) {
                        if (MyFansUserLikeButton.this.fQK == null) {
                            k kVar = new k(MyFansUserLikeButton.this.mContext.getContext());
                            kVar.setTitleText(MyFansUserLikeButton.this.mContext.getString(R.string.confirm_unlike));
                            ArrayList arrayList = new ArrayList();
                            g gVar = new g(MyFansUserLikeButton.this.mContext.getString(R.string.confirm), kVar);
                            gVar.a(new k.b() { // from class: com.baidu.tieba.myAttentionAndFans.MyFansUserLikeButton.1.1
                                @Override // com.baidu.tbadk.core.dialog.k.b
                                public void onClick() {
                                    if (onClickListener != null) {
                                        onClickListener.onClick(view);
                                        if (MyFansUserLikeButton.this.currentPage != 1) {
                                            if (MyFansUserLikeButton.this.currentPage == 2) {
                                                TiebaStatic.log(new an("C12603").cx("obj_param1", MyFansUserLikeButton.this.uid));
                                            }
                                        } else {
                                            TiebaStatic.log(new an("c12773").cx("obj_param1", MyFansUserLikeButton.this.uid));
                                        }
                                        com.baidu.adp.lib.f.g.b(MyFansUserLikeButton.this.fQK, MyFansUserLikeButton.this.mContext);
                                    }
                                }
                            });
                            arrayList.add(gVar);
                            kVar.a(new k.a() { // from class: com.baidu.tieba.myAttentionAndFans.MyFansUserLikeButton.1.2
                                @Override // com.baidu.tbadk.core.dialog.k.a
                                public void onClick() {
                                    if (MyFansUserLikeButton.this.fQK != null) {
                                        com.baidu.adp.lib.f.g.b(MyFansUserLikeButton.this.fQK, MyFansUserLikeButton.this.mContext);
                                    }
                                }
                            });
                            kVar.az(arrayList);
                            MyFansUserLikeButton.this.fQK = new i(MyFansUserLikeButton.this.mContext, kVar);
                            MyFansUserLikeButton.this.fQK.ae(0.7f);
                        }
                        com.baidu.adp.lib.f.g.a(MyFansUserLikeButton.this.fQK, MyFansUserLikeButton.this.mContext);
                        return;
                    }
                    return;
                }
                onClickListener.onClick(view);
            }
        });
    }
}
