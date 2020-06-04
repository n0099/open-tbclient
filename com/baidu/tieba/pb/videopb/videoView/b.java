package com.baidu.tieba.pb.videopb.videoView;

import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.a.d;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.data.l;
import com.baidu.tieba.tbadkCore.data.q;
import com.baidu.tieba.view.SortSwitchButton;
import java.util.ArrayList;
import java.util.List;
import tbclient.PbPage.PbSortType;
/* loaded from: classes9.dex */
public class b {
    private int aNV;
    private int aNW;
    private View.OnClickListener dUl;
    private SortSwitchButton.a jIL;
    private TextView jRE;
    private SortSwitchButton jRF;
    private l jRR;
    private TextView kfW;
    private TextView kfX;
    private View mRootView;
    public boolean jRU = d.aMn();
    private int jRP = 0;
    private int kfY = 0;
    private SortSwitchButton.a jMC = new SortSwitchButton.a() { // from class: com.baidu.tieba.pb.videopb.videoView.b.1
        @Override // com.baidu.tieba.view.SortSwitchButton.a
        public boolean uv(int i) {
            if (b.this.jIL != null) {
                return b.this.jIL.uv(i);
            }
            return true;
        }
    };
    private View.OnClickListener jRV = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.videoView.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.dUl != null) {
                b.this.dUl.onClick(view);
            }
            if (j.isNetWorkAvailable()) {
                if (view == null || !(view.getTag() instanceof Boolean) || ((Boolean) view.getTag()).booleanValue()) {
                    if (view != b.this.kfW) {
                        if (view == b.this.kfX) {
                            b.this.setSelection(1);
                            return;
                        }
                        return;
                    }
                    b.this.setSelection(0);
                }
            }
        }
    };
    private View.OnClickListener jRW = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.videoView.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.dUl != null) {
                b.this.dUl.onClick(view);
            }
        }
    };

    public void setSelection(int i) {
        this.kfY = i;
        if (i == 0) {
            this.kfW.setTypeface(Typeface.defaultFromStyle(1));
            this.kfX.setTypeface(Typeface.defaultFromStyle(0));
            this.kfW.setTextColor(this.aNV);
            this.kfX.setTextColor(this.aNW);
        } else if (i == 1) {
            this.kfW.setTypeface(Typeface.defaultFromStyle(0));
            this.kfX.setTypeface(Typeface.defaultFromStyle(1));
            this.kfW.setTextColor(this.aNW);
            this.kfX.setTextColor(this.aNV);
        }
    }

    public b(View view) {
        if (view != null) {
            this.mRootView = view;
            this.kfW = (TextView) this.mRootView.findViewById(R.id.all_reply);
            this.kfW.setOnClickListener(this.jRV);
            this.kfX = (TextView) this.mRootView.findViewById(R.id.owner_reply);
            this.kfX.setOnClickListener(this.jRV);
            if (this.jRU) {
                this.jRF = (SortSwitchButton) this.mRootView.findViewById(R.id.video_pb_sort_switch_btn);
                this.jRF.setOnSwitchChangeListener(this.jMC);
            } else {
                this.jRE = (TextView) this.mRootView.findViewById(R.id.pb_sort_type);
                this.jRE.setOnClickListener(this.jRW);
                this.jRE.setVisibility(0);
            }
            if (com.baidu.tbadk.util.a.bgi().aXF()) {
                if (this.jRU) {
                    this.jRF.changeState(2);
                } else {
                    bp(2, "");
                }
            } else if (this.jRU) {
                this.jRF.changeState(0);
            } else {
                bp(0, "");
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void rN(boolean z) {
        if (z) {
            setSelection(1);
        } else {
            setSelection(0);
        }
    }

    public void bp(int i, String str) {
        this.jRP = i;
        this.jRE.setVisibility(0);
        if (str.length() > 0) {
            this.jRE.setText(str);
        } else if (this.jRP == 0) {
            this.jRE.setText(R.string.sort_type_new);
        } else if (this.jRP == 1) {
            this.jRE.setText(R.string.sort_type_old);
        } else if (this.jRP == 2) {
            this.jRE.setText(R.string.sort_type_hot);
        }
    }

    public void onChangeSkinType(int i) {
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_e);
        this.aNV = am.getColor(R.color.cp_cont_b);
        this.aNW = am.getColor(R.color.cp_cont_j);
        setSelection(this.kfY);
        if (this.jRU) {
            this.jRF.onChangeSkinType();
            return;
        }
        am.setViewTextColor(this.jRE, (int) R.color.cp_cont_j);
        this.jRE.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.aUW().a(R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null);
    }

    public void a(l lVar) {
        this.jRR = lVar;
        if (lVar != null) {
            if (lVar.TK == l.jGo) {
                this.kfW.setClickable(true);
                this.kfW.setText(TbadkCoreApplication.getInst().getString(R.string.all_reply));
                this.kfX.setVisibility(0);
                rN(lVar.jGt);
            }
            if (lVar.isDynamic) {
                this.kfX.setVisibility(8);
                if (this.jRU) {
                    this.jRF.setVisibility(8);
                } else {
                    this.jRE.setVisibility(8);
                }
            } else {
                this.kfX.setVisibility(0);
                if (this.jRU) {
                    if (lVar.jGu != null) {
                        this.jRF.setVisibility(0);
                        int i = 0;
                        while (true) {
                            if (i >= lVar.jGu.size()) {
                                i = 0;
                                break;
                            } else if (lVar.jGu.get(i) != null && lVar.sortType == lVar.jGu.get(i).sort_type.intValue()) {
                                break;
                            } else {
                                i++;
                            }
                        }
                        n(lVar.jGu, i);
                    }
                } else {
                    this.jRE.setVisibility(0);
                    bp(lVar.sortType, lVar.jGs);
                }
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void n(List<PbSortType> list, int i) {
        if (v.isEmpty(list)) {
            this.jRF.setVisibility(8);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (PbSortType pbSortType : list) {
            q qVar = new q();
            qVar.DV(pbSortType.sort_type.intValue());
            qVar.ME(pbSortType.sort_name);
            arrayList.add(qVar);
        }
        this.jRF.setVisibility(0);
        this.jRF.setData(arrayList, i);
    }

    public void setOnSwitchChangeListener(SortSwitchButton.a aVar) {
        this.jIL = aVar;
    }

    public void U(View.OnClickListener onClickListener) {
        this.dUl = onClickListener;
    }
}
