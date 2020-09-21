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
/* loaded from: classes21.dex */
public class b {
    private int aZD;
    private int aZE;
    private View.OnClickListener etM;
    private SortSwitchButton.a kIV;
    private SortSwitchButton kSH;
    private n kST;
    private TextView lho;
    private TextView lhp;
    private View mRootView;
    private int kSR = 0;
    private int lhq = 0;
    private SortSwitchButton.a kNd = new SortSwitchButton.a() { // from class: com.baidu.tieba.pb.videopb.videoView.b.1
        @Override // com.baidu.tieba.view.SortSwitchButton.a
        public boolean yk(int i) {
            if (b.this.kIV != null) {
                return b.this.kIV.yk(i);
            }
            return true;
        }
    };
    private View.OnClickListener kSW = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.videoView.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.etM != null) {
                b.this.etM.onClick(view);
            }
            if (j.isNetWorkAvailable()) {
                if (view == null || !(view.getTag() instanceof Boolean) || ((Boolean) view.getTag()).booleanValue()) {
                    if (view != b.this.lho) {
                        if (view == b.this.lhp) {
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
    private View.OnClickListener kSX = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.videoView.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.etM != null) {
                b.this.etM.onClick(view);
            }
        }
    };

    public void setSelection(int i) {
        this.lhq = i;
        if (i == 0) {
            this.lho.setTypeface(Typeface.defaultFromStyle(1));
            this.lhp.setTypeface(Typeface.defaultFromStyle(0));
            this.lho.setTextColor(this.aZD);
            this.lhp.setTextColor(this.aZE);
        } else if (i == 1) {
            this.lho.setTypeface(Typeface.defaultFromStyle(0));
            this.lhp.setTypeface(Typeface.defaultFromStyle(1));
            this.lho.setTextColor(this.aZE);
            this.lhp.setTextColor(this.aZD);
        }
    }

    public b(View view) {
        if (view != null) {
            this.mRootView = view;
            this.lho = (TextView) this.mRootView.findViewById(R.id.all_reply);
            this.lho.setOnClickListener(this.kSW);
            this.lhp = (TextView) this.mRootView.findViewById(R.id.owner_reply);
            this.lhp.setOnClickListener(this.kSW);
            this.kSH = (SortSwitchButton) this.mRootView.findViewById(R.id.video_pb_sort_switch_btn);
            this.kSH.setOnSwitchChangeListener(this.kNd);
            this.kSH.iX(2);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void ty(boolean z) {
        if (z) {
            setSelection(1);
        } else {
            setSelection(0);
        }
    }

    public void onChangeSkinType(int i) {
        ap.setBackgroundColor(this.mRootView, R.color.cp_bg_line_e);
        this.aZD = ap.getColor(R.color.cp_cont_b);
        this.aZE = ap.getColor(R.color.cp_cont_j);
        setSelection(this.lhq);
        this.kSH.onChangeSkinType();
    }

    public void a(n nVar) {
        this.kST = nVar;
        if (nVar != null) {
            if (nVar.Vf == n.kGC) {
                this.lho.setClickable(true);
                this.lho.setText(TbadkCoreApplication.getInst().getString(R.string.all_reply));
                this.lhp.setVisibility(0);
                ty(nVar.kGH);
            }
            if (nVar.isDynamic) {
                this.lhp.setVisibility(8);
                this.kSH.setVisibility(8);
            } else {
                this.lhp.setVisibility(0);
                if (nVar.kGI != null) {
                    this.kSH.setVisibility(0);
                    int i = 0;
                    while (true) {
                        if (i >= nVar.kGI.size()) {
                            i = 0;
                            break;
                        } else if (nVar.kGI.get(i) != null && nVar.sortType == nVar.kGI.get(i).sort_type.intValue()) {
                            break;
                        } else {
                            i++;
                        }
                    }
                    p(nVar.kGI, i);
                }
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void p(List<PbSortType> list, int i) {
        if (y.isEmpty(list)) {
            this.kSH.setVisibility(8);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (PbSortType pbSortType : list) {
            p pVar = new p();
            pVar.It(pbSortType.sort_type.intValue());
            pVar.Ro(pbSortType.sort_name);
            arrayList.add(pVar);
        }
        this.kSH.setVisibility(0);
        this.kSH.setData(arrayList, i);
    }

    public void setOnSwitchChangeListener(SortSwitchButton.a aVar) {
        this.kIV = aVar;
    }

    public void X(View.OnClickListener onClickListener) {
        this.etM = onClickListener;
    }
}
