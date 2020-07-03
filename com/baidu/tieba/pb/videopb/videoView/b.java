package com.baidu.tieba.pb.videopb.videoView;

import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.a.d;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.data.l;
import com.baidu.tieba.tbadkCore.data.p;
import com.baidu.tieba.view.SortSwitchButton;
import java.util.ArrayList;
import java.util.List;
import tbclient.PbPage.PbSortType;
/* loaded from: classes9.dex */
public class b {
    private int aQB;
    private int aQC;
    private View.OnClickListener ebA;
    private SortSwitchButton.a kcv;
    private l klH;
    private TextView klu;
    private SortSwitchButton klv;
    private TextView kzK;
    private TextView kzL;
    private View mRootView;
    public boolean klK = d.aNQ();
    private int klF = 0;
    private int kzM = 0;
    private SortSwitchButton.a kgn = new SortSwitchButton.a() { // from class: com.baidu.tieba.pb.videopb.videoView.b.1
        @Override // com.baidu.tieba.view.SortSwitchButton.a
        public boolean va(int i) {
            if (b.this.kcv != null) {
                return b.this.kcv.va(i);
            }
            return true;
        }
    };
    private View.OnClickListener klL = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.videoView.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.ebA != null) {
                b.this.ebA.onClick(view);
            }
            if (j.isNetWorkAvailable()) {
                if (view == null || !(view.getTag() instanceof Boolean) || ((Boolean) view.getTag()).booleanValue()) {
                    if (view != b.this.kzK) {
                        if (view == b.this.kzL) {
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
    private View.OnClickListener klM = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.videoView.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.ebA != null) {
                b.this.ebA.onClick(view);
            }
        }
    };

    public void setSelection(int i) {
        this.kzM = i;
        if (i == 0) {
            this.kzK.setTypeface(Typeface.defaultFromStyle(1));
            this.kzL.setTypeface(Typeface.defaultFromStyle(0));
            this.kzK.setTextColor(this.aQB);
            this.kzL.setTextColor(this.aQC);
        } else if (i == 1) {
            this.kzK.setTypeface(Typeface.defaultFromStyle(0));
            this.kzL.setTypeface(Typeface.defaultFromStyle(1));
            this.kzK.setTextColor(this.aQC);
            this.kzL.setTextColor(this.aQB);
        }
    }

    public b(View view) {
        if (view != null) {
            this.mRootView = view;
            this.kzK = (TextView) this.mRootView.findViewById(R.id.all_reply);
            this.kzK.setOnClickListener(this.klL);
            this.kzL = (TextView) this.mRootView.findViewById(R.id.owner_reply);
            this.kzL.setOnClickListener(this.klL);
            if (this.klK) {
                this.klv = (SortSwitchButton) this.mRootView.findViewById(R.id.video_pb_sort_switch_btn);
                this.klv.setOnSwitchChangeListener(this.kgn);
            } else {
                this.klu = (TextView) this.mRootView.findViewById(R.id.pb_sort_type);
                this.klu.setOnClickListener(this.klM);
                this.klu.setVisibility(0);
            }
            if (this.klK) {
                this.klv.changeState(2);
            } else {
                bt(2, "");
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void sb(boolean z) {
        if (z) {
            setSelection(1);
        } else {
            setSelection(0);
        }
    }

    public void bt(int i, String str) {
        this.klF = i;
        this.klu.setVisibility(0);
        if (str.length() > 0) {
            this.klu.setText(str);
        } else if (this.klF == 0) {
            this.klu.setText(R.string.sort_type_new);
        } else if (this.klF == 1) {
            this.klu.setText(R.string.sort_type_old);
        } else if (this.klF == 2) {
            this.klu.setText(R.string.sort_type_hot);
        }
    }

    public void onChangeSkinType(int i) {
        an.setBackgroundColor(this.mRootView, R.color.cp_bg_line_e);
        this.aQB = an.getColor(R.color.cp_cont_b);
        this.aQC = an.getColor(R.color.cp_cont_j);
        setSelection(this.kzM);
        if (this.klK) {
            this.klv.onChangeSkinType();
            return;
        }
        an.setViewTextColor(this.klu, (int) R.color.cp_cont_j);
        this.klu.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.aWQ().a(R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null);
    }

    public void a(l lVar) {
        this.klH = lVar;
        if (lVar != null) {
            if (lVar.Un == l.jZY) {
                this.kzK.setClickable(true);
                this.kzK.setText(TbadkCoreApplication.getInst().getString(R.string.all_reply));
                this.kzL.setVisibility(0);
                sb(lVar.kad);
            }
            if (lVar.isDynamic) {
                this.kzL.setVisibility(8);
                if (this.klK) {
                    this.klv.setVisibility(8);
                } else {
                    this.klu.setVisibility(8);
                }
            } else {
                this.kzL.setVisibility(0);
                if (this.klK) {
                    if (lVar.kae != null) {
                        this.klv.setVisibility(0);
                        int i = 0;
                        while (true) {
                            if (i >= lVar.kae.size()) {
                                i = 0;
                                break;
                            } else if (lVar.kae.get(i) != null && lVar.sortType == lVar.kae.get(i).sort_type.intValue()) {
                                break;
                            } else {
                                i++;
                            }
                        }
                        o(lVar.kae, i);
                    }
                } else {
                    this.klu.setVisibility(0);
                    bt(lVar.sortType, lVar.kac);
                }
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void o(List<PbSortType> list, int i) {
        if (w.isEmpty(list)) {
            this.klv.setVisibility(8);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (PbSortType pbSortType : list) {
            p pVar = new p();
            pVar.EX(pbSortType.sort_type.intValue());
            pVar.Ng(pbSortType.sort_name);
            arrayList.add(pVar);
        }
        this.klv.setVisibility(0);
        this.klv.setData(arrayList, i);
    }

    public void setOnSwitchChangeListener(SortSwitchButton.a aVar) {
        this.kcv = aVar;
    }

    public void V(View.OnClickListener onClickListener) {
        this.ebA = onClickListener;
    }
}
