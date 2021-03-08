package com.baidu.tieba.myAttentionAndFans;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.adp.base.f;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.g;
import com.baidu.tbadk.core.dialog.i;
import com.baidu.tbadk.core.dialog.k;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class MyFansUserLikeButton extends CommonUserLikeButton {
    private int currentPage;
    private i lxV;
    private f mContext;
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
    public void aM(boolean z) {
    }

    @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton, com.baidu.tbadk.core.view.userLike.b
    public void r(boolean z, int i) {
        this.foT = z;
        if (z) {
            switch (i) {
                case 1:
                    setTextSize(0, l.getDimens(getContext(), R.dimen.ds26));
                    setText(this.foR);
                    break;
                case 2:
                    setTextSize(0, l.getDimens(getContext(), R.dimen.ds24));
                    setText(R.string.each_concerned);
                    break;
                default:
                    setTextSize(0, l.getDimens(getContext(), R.dimen.ds26));
                    setText(this.foR);
                    break;
            }
        } else {
            setTextSize(0, l.getDimens(getContext(), R.dimen.ds26));
            setText(this.foS);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setStatsParams(int i, String str) {
        this.currentPage = i;
        this.uid = str;
    }

    @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton
    public void onChangeSkinType(int i) {
        if (this.foT) {
            ap.setViewTextColor(this, R.color.btn_forum_focus_gray_color);
            ap.setBackgroundResource(this, R.drawable.btn_transparent_gray_border);
            return;
        }
        ap.setViewTextColor(this, R.color.btn_forum_focus_color);
        ap.setBackgroundResource(this, R.drawable.btn_transparent_focus_border_bg);
    }

    public void setContext(f fVar) {
        this.mContext = fVar;
    }

    @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton, com.baidu.tbadk.core.view.userLike.b
    public void i(final View.OnClickListener onClickListener) {
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.MyFansUserLikeButton.1
            @Override // android.view.View.OnClickListener
            public void onClick(final View view) {
                if (MyFansUserLikeButton.this.currentPage != 1) {
                    if (MyFansUserLikeButton.this.currentPage == 2) {
                        TiebaStatic.log(new ar("c12605").aq("obj_locate", MyFansUserLikeButton.this.foT ? 3 : 2).dR("obj_param1", MyFansUserLikeButton.this.uid));
                    }
                } else {
                    TiebaStatic.log(new ar("c12772").dR("obj_locate", MyFansUserLikeButton.this.foT ? "3" : "2").dR("obj_param1", MyFansUserLikeButton.this.uid));
                }
                if (MyFansUserLikeButton.this.foT) {
                    if (MyFansUserLikeButton.this.mContext != null) {
                        if (MyFansUserLikeButton.this.lxV == null) {
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
                                                TiebaStatic.log(new ar("C12603").dR("obj_param1", MyFansUserLikeButton.this.uid));
                                            }
                                        } else {
                                            TiebaStatic.log(new ar("c12773").dR("obj_param1", MyFansUserLikeButton.this.uid));
                                        }
                                        com.baidu.adp.lib.f.g.b(MyFansUserLikeButton.this.lxV, MyFansUserLikeButton.this.mContext);
                                    }
                                }
                            });
                            arrayList.add(gVar);
                            kVar.a(new k.a() { // from class: com.baidu.tieba.myAttentionAndFans.MyFansUserLikeButton.1.2
                                @Override // com.baidu.tbadk.core.dialog.k.a
                                public void onClick() {
                                    if (MyFansUserLikeButton.this.lxV != null) {
                                        com.baidu.adp.lib.f.g.b(MyFansUserLikeButton.this.lxV, MyFansUserLikeButton.this.mContext);
                                    }
                                }
                            });
                            kVar.bw(arrayList);
                            MyFansUserLikeButton.this.lxV = new i(MyFansUserLikeButton.this.mContext, kVar);
                            MyFansUserLikeButton.this.lxV.ag(0.7f);
                        }
                        com.baidu.adp.lib.f.g.a(MyFansUserLikeButton.this.lxV, MyFansUserLikeButton.this.mContext);
                        return;
                    }
                    return;
                }
                onClickListener.onClick(view);
            }
        });
    }
}
