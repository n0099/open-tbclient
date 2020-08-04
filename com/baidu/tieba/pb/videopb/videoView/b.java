package com.baidu.tieba.pb.videopb.videoView;

import android.graphics.Typeface;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.data.n;
import com.baidu.tieba.tbadkCore.data.p;
import com.baidu.tieba.view.SortSwitchButton;
import java.util.ArrayList;
import java.util.List;
import tbclient.PbPage.PbSortType;
/* loaded from: classes16.dex */
public class b {
    private int aRU;
    private int aRV;
    private View.OnClickListener ehM;
    private TextView kIO;
    private TextView kIP;
    private SortSwitchButton.a kkZ;
    private n kuH;
    private SortSwitchButton kuv;
    private View mRootView;
    private int kuF = 0;
    private int kIQ = 0;
    private SortSwitchButton.a kpg = new SortSwitchButton.a() { // from class: com.baidu.tieba.pb.videopb.videoView.b.1
        @Override // com.baidu.tieba.view.SortSwitchButton.a
        public boolean vs(int i) {
            if (b.this.kkZ != null) {
                return b.this.kkZ.vs(i);
            }
            return true;
        }
    };
    private View.OnClickListener kuK = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.videoView.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.ehM != null) {
                b.this.ehM.onClick(view);
            }
            if (j.isNetWorkAvailable()) {
                if (view == null || !(view.getTag() instanceof Boolean) || ((Boolean) view.getTag()).booleanValue()) {
                    if (view != b.this.kIO) {
                        if (view == b.this.kIP) {
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
    private View.OnClickListener kuL = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.videoView.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.ehM != null) {
                b.this.ehM.onClick(view);
            }
        }
    };

    public void setSelection(int i) {
        this.kIQ = i;
        if (i == 0) {
            this.kIO.setTypeface(Typeface.defaultFromStyle(1));
            this.kIP.setTypeface(Typeface.defaultFromStyle(0));
            this.kIO.setTextColor(this.aRU);
            this.kIP.setTextColor(this.aRV);
        } else if (i == 1) {
            this.kIO.setTypeface(Typeface.defaultFromStyle(0));
            this.kIP.setTypeface(Typeface.defaultFromStyle(1));
            this.kIO.setTextColor(this.aRV);
            this.kIP.setTextColor(this.aRU);
        }
    }

    public b(View view) {
        if (view != null) {
            this.mRootView = view;
            this.kIO = (TextView) this.mRootView.findViewById(R.id.all_reply);
            this.kIO.setOnClickListener(this.kuK);
            this.kIP = (TextView) this.mRootView.findViewById(R.id.owner_reply);
            this.kIP.setOnClickListener(this.kuK);
            this.kuv = (SortSwitchButton) this.mRootView.findViewById(R.id.video_pb_sort_switch_btn);
            this.kuv.setOnSwitchChangeListener(this.kpg);
            this.kuv.changeState(2);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void sG(boolean z) {
        if (z) {
            setSelection(1);
        } else {
            setSelection(0);
        }
    }

    public void onChangeSkinType(int i) {
        ao.setBackgroundColor(this.mRootView, R.color.cp_bg_line_e);
        this.aRU = ao.getColor(R.color.cp_cont_b);
        this.aRV = ao.getColor(R.color.cp_cont_j);
        setSelection(this.kIQ);
        this.kuv.onChangeSkinType();
    }

    public void a(n nVar) {
        this.kuH = nVar;
        if (nVar != null) {
            if (nVar.Uh == n.kiG) {
                this.kIO.setClickable(true);
                this.kIO.setText(TbadkCoreApplication.getInst().getString(R.string.all_reply));
                this.kIP.setVisibility(0);
                sG(nVar.kiL);
            }
            if (nVar.isDynamic) {
                this.kIP.setVisibility(8);
                this.kuv.setVisibility(8);
            } else {
                this.kIP.setVisibility(0);
                if (nVar.kiM != null) {
                    this.kuv.setVisibility(0);
                    int i = 0;
                    while (true) {
                        if (i >= nVar.kiM.size()) {
                            i = 0;
                            break;
                        } else if (nVar.kiM.get(i) != null && nVar.sortType == nVar.kiM.get(i).sort_type.intValue()) {
                            break;
                        } else {
                            i++;
                        }
                    }
                    m(nVar.kiM, i);
                }
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void m(List<PbSortType> list, int i) {
        if (x.isEmpty(list)) {
            this.kuv.setVisibility(8);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (PbSortType pbSortType : list) {
            p pVar = new p();
            pVar.Ft(pbSortType.sort_type.intValue());
            pVar.NO(pbSortType.sort_name);
            arrayList.add(pVar);
        }
        this.kuv.setVisibility(0);
        this.kuv.setData(arrayList, i);
    }

    public void setOnSwitchChangeListener(SortSwitchButton.a aVar) {
        this.kkZ = aVar;
    }

    public void W(View.OnClickListener onClickListener) {
        this.ehM = onClickListener;
    }
}
