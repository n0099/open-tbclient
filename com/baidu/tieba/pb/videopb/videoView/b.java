package com.baidu.tieba.pb.videopb.videoView;

import android.graphics.Typeface;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.data.n;
import com.baidu.tieba.tbadkCore.data.p;
import com.baidu.tieba.view.SortSwitchButton;
import java.util.ArrayList;
import java.util.List;
import tbclient.PbPage.PbSortType;
/* loaded from: classes22.dex */
public class b {
    private int bem;
    private int ben;
    private View.OnClickListener eOs;
    private TextView lJd;
    private TextView lJe;
    private SortSwitchButton.a lkF;
    private n luJ;
    private SortSwitchButton lux;
    private View mRootView;
    private int luH = 0;
    private int lJf = 0;
    private SortSwitchButton.a loS = new SortSwitchButton.a() { // from class: com.baidu.tieba.pb.videopb.videoView.b.1
        @Override // com.baidu.tieba.view.SortSwitchButton.a
        public boolean zj(int i) {
            if (b.this.lkF != null) {
                return b.this.lkF.zj(i);
            }
            return true;
        }
    };
    private View.OnClickListener luM = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.videoView.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.eOs != null) {
                b.this.eOs.onClick(view);
            }
            if (j.isNetWorkAvailable()) {
                if (view == null || !(view.getTag() instanceof Boolean) || ((Boolean) view.getTag()).booleanValue()) {
                    if (view != b.this.lJd) {
                        if (view == b.this.lJe) {
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
    private View.OnClickListener luN = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.videoView.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.eOs != null) {
                b.this.eOs.onClick(view);
            }
        }
    };

    public void setSelection(int i) {
        this.lJf = i;
        if (i == 0) {
            this.lJd.setTypeface(Typeface.defaultFromStyle(1));
            this.lJe.setTypeface(Typeface.defaultFromStyle(0));
            this.lJd.setTextColor(this.bem);
            this.lJe.setTextColor(this.ben);
        } else if (i == 1) {
            this.lJd.setTypeface(Typeface.defaultFromStyle(0));
            this.lJe.setTypeface(Typeface.defaultFromStyle(1));
            this.lJd.setTextColor(this.ben);
            this.lJe.setTextColor(this.bem);
        }
    }

    public b(View view) {
        if (view != null) {
            this.mRootView = view;
            this.lJd = (TextView) this.mRootView.findViewById(R.id.all_reply);
            this.lJd.setOnClickListener(this.luM);
            this.lJe = (TextView) this.mRootView.findViewById(R.id.owner_reply);
            this.lJe.setOnClickListener(this.luM);
            this.lux = (SortSwitchButton) this.mRootView.findViewById(R.id.video_pb_sort_switch_btn);
            this.lux.setOnSwitchChangeListener(this.loS);
            this.lux.jF(2);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void uw(boolean z) {
        if (z) {
            setSelection(1);
        } else {
            setSelection(0);
        }
    }

    public void onChangeSkinType(int i) {
        ap.setBackgroundColor(this.mRootView, R.color.cp_bg_line_e);
        this.bem = ap.getColor(R.color.cp_cont_b);
        this.ben = ap.getColor(R.color.cp_cont_j);
        setSelection(this.lJf);
        this.lux.onChangeSkinType();
    }

    public void a(n nVar) {
        this.luJ = nVar;
        if (nVar != null) {
            if (nVar.Vw == n.lim) {
                this.lJd.setClickable(true);
                this.lJd.setText(TbadkCoreApplication.getInst().getString(R.string.all_reply));
                this.lJe.setVisibility(0);
                uw(nVar.lir);
            }
            if (nVar.isDynamic) {
                this.lJe.setVisibility(8);
                this.lux.setVisibility(8);
            } else {
                this.lJe.setVisibility(0);
                if (nVar.lis != null) {
                    this.lux.setVisibility(0);
                    int i = 0;
                    while (true) {
                        if (i >= nVar.lis.size()) {
                            i = 0;
                            break;
                        } else if (nVar.lis.get(i) != null && nVar.sortType == nVar.lis.get(i).sort_type.intValue()) {
                            break;
                        } else {
                            i++;
                        }
                    }
                    p(nVar.lis, i);
                }
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void p(List<PbSortType> list, int i) {
        if (y.isEmpty(list)) {
            this.lux.setVisibility(8);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (PbSortType pbSortType : list) {
            p pVar = new p();
            pVar.Jr(pbSortType.sort_type.intValue());
            pVar.SB(pbSortType.sort_name);
            arrayList.add(pVar);
        }
        this.lux.setVisibility(0);
        this.lux.setData(arrayList, i);
    }

    public void setOnSwitchChangeListener(SortSwitchButton.a aVar) {
        this.lkF = aVar;
    }

    public void X(View.OnClickListener onClickListener) {
        this.eOs = onClickListener;
    }
}
