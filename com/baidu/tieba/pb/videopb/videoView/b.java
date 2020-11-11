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
    private int bfI;
    private int bfJ;
    private View.OnClickListener eUh;
    private n lAG;
    private SortSwitchButton lAu;
    private TextView lOZ;
    private TextView lPa;
    private SortSwitchButton.a lqG;
    private View mRootView;
    private int lAE = 0;
    private int lPb = 0;
    private SortSwitchButton.a luP = new SortSwitchButton.a() { // from class: com.baidu.tieba.pb.videopb.videoView.b.1
        @Override // com.baidu.tieba.view.SortSwitchButton.a
        public boolean zw(int i) {
            if (b.this.lqG != null) {
                return b.this.lqG.zw(i);
            }
            return true;
        }
    };
    private View.OnClickListener lAJ = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.videoView.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.eUh != null) {
                b.this.eUh.onClick(view);
            }
            if (j.isNetWorkAvailable()) {
                if (view == null || !(view.getTag() instanceof Boolean) || ((Boolean) view.getTag()).booleanValue()) {
                    if (view != b.this.lOZ) {
                        if (view == b.this.lPa) {
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
    private View.OnClickListener lAK = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.videoView.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.eUh != null) {
                b.this.eUh.onClick(view);
            }
        }
    };

    public void setSelection(int i) {
        this.lPb = i;
        if (i == 0) {
            this.lOZ.setTypeface(Typeface.defaultFromStyle(1));
            this.lPa.setTypeface(Typeface.defaultFromStyle(0));
            this.lOZ.setTextColor(this.bfI);
            this.lPa.setTextColor(this.bfJ);
        } else if (i == 1) {
            this.lOZ.setTypeface(Typeface.defaultFromStyle(0));
            this.lPa.setTypeface(Typeface.defaultFromStyle(1));
            this.lOZ.setTextColor(this.bfJ);
            this.lPa.setTextColor(this.bfI);
        }
    }

    public b(View view) {
        if (view != null) {
            this.mRootView = view;
            this.lOZ = (TextView) this.mRootView.findViewById(R.id.all_reply);
            this.lOZ.setOnClickListener(this.lAJ);
            this.lPa = (TextView) this.mRootView.findViewById(R.id.owner_reply);
            this.lPa.setOnClickListener(this.lAJ);
            this.lAu = (SortSwitchButton) this.mRootView.findViewById(R.id.video_pb_sort_switch_btn);
            this.lAu.setOnSwitchChangeListener(this.luP);
            this.lAu.jP(2);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void uF(boolean z) {
        if (z) {
            setSelection(1);
        } else {
            setSelection(0);
        }
    }

    public void onChangeSkinType(int i) {
        ap.setBackgroundColor(this.mRootView, R.color.cp_bg_line_e);
        this.bfI = ap.getColor(R.color.cp_cont_b);
        this.bfJ = ap.getColor(R.color.cp_cont_j);
        setSelection(this.lPb);
        this.lAu.onChangeSkinType();
    }

    public void a(n nVar) {
        this.lAG = nVar;
        if (nVar != null) {
            if (nVar.Vw == n.lol) {
                this.lOZ.setClickable(true);
                this.lOZ.setText(TbadkCoreApplication.getInst().getString(R.string.all_reply));
                this.lPa.setVisibility(0);
                uF(nVar.lor);
            }
            if (nVar.isDynamic) {
                this.lPa.setVisibility(8);
                this.lAu.setVisibility(8);
            } else {
                this.lPa.setVisibility(0);
                if (nVar.los != null) {
                    this.lAu.setVisibility(0);
                    int i = 0;
                    while (true) {
                        if (i >= nVar.los.size()) {
                            i = 0;
                            break;
                        } else if (nVar.los.get(i) != null && nVar.sortType == nVar.los.get(i).sort_type.intValue()) {
                            break;
                        } else {
                            i++;
                        }
                    }
                    p(nVar.los, i);
                }
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void p(List<PbSortType> list, int i) {
        if (y.isEmpty(list)) {
            this.lAu.setVisibility(8);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (PbSortType pbSortType : list) {
            p pVar = new p();
            pVar.JE(pbSortType.sort_type.intValue());
            pVar.SS(pbSortType.sort_name);
            arrayList.add(pVar);
        }
        this.lAu.setVisibility(0);
        this.lAu.setData(arrayList, i);
    }

    public void setOnSwitchChangeListener(SortSwitchButton.a aVar) {
        this.lqG = aVar;
    }

    public void Y(View.OnClickListener onClickListener) {
        this.eUh = onClickListener;
    }
}
