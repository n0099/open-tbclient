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
    private TextView kIM;
    private TextView kIN;
    private SortSwitchButton.a kkX;
    private n kuF;
    private SortSwitchButton kut;
    private View mRootView;
    private int kuD = 0;
    private int kIO = 0;
    private SortSwitchButton.a kpe = new SortSwitchButton.a() { // from class: com.baidu.tieba.pb.videopb.videoView.b.1
        @Override // com.baidu.tieba.view.SortSwitchButton.a
        public boolean vs(int i) {
            if (b.this.kkX != null) {
                return b.this.kkX.vs(i);
            }
            return true;
        }
    };
    private View.OnClickListener kuI = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.videoView.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.ehM != null) {
                b.this.ehM.onClick(view);
            }
            if (j.isNetWorkAvailable()) {
                if (view == null || !(view.getTag() instanceof Boolean) || ((Boolean) view.getTag()).booleanValue()) {
                    if (view != b.this.kIM) {
                        if (view == b.this.kIN) {
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
    private View.OnClickListener kuJ = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.videoView.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.ehM != null) {
                b.this.ehM.onClick(view);
            }
        }
    };

    public void setSelection(int i) {
        this.kIO = i;
        if (i == 0) {
            this.kIM.setTypeface(Typeface.defaultFromStyle(1));
            this.kIN.setTypeface(Typeface.defaultFromStyle(0));
            this.kIM.setTextColor(this.aRU);
            this.kIN.setTextColor(this.aRV);
        } else if (i == 1) {
            this.kIM.setTypeface(Typeface.defaultFromStyle(0));
            this.kIN.setTypeface(Typeface.defaultFromStyle(1));
            this.kIM.setTextColor(this.aRV);
            this.kIN.setTextColor(this.aRU);
        }
    }

    public b(View view) {
        if (view != null) {
            this.mRootView = view;
            this.kIM = (TextView) this.mRootView.findViewById(R.id.all_reply);
            this.kIM.setOnClickListener(this.kuI);
            this.kIN = (TextView) this.mRootView.findViewById(R.id.owner_reply);
            this.kIN.setOnClickListener(this.kuI);
            this.kut = (SortSwitchButton) this.mRootView.findViewById(R.id.video_pb_sort_switch_btn);
            this.kut.setOnSwitchChangeListener(this.kpe);
            this.kut.changeState(2);
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
        setSelection(this.kIO);
        this.kut.onChangeSkinType();
    }

    public void a(n nVar) {
        this.kuF = nVar;
        if (nVar != null) {
            if (nVar.Uh == n.kiE) {
                this.kIM.setClickable(true);
                this.kIM.setText(TbadkCoreApplication.getInst().getString(R.string.all_reply));
                this.kIN.setVisibility(0);
                sG(nVar.kiJ);
            }
            if (nVar.isDynamic) {
                this.kIN.setVisibility(8);
                this.kut.setVisibility(8);
            } else {
                this.kIN.setVisibility(0);
                if (nVar.kiK != null) {
                    this.kut.setVisibility(0);
                    int i = 0;
                    while (true) {
                        if (i >= nVar.kiK.size()) {
                            i = 0;
                            break;
                        } else if (nVar.kiK.get(i) != null && nVar.sortType == nVar.kiK.get(i).sort_type.intValue()) {
                            break;
                        } else {
                            i++;
                        }
                    }
                    m(nVar.kiK, i);
                }
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void m(List<PbSortType> list, int i) {
        if (x.isEmpty(list)) {
            this.kut.setVisibility(8);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (PbSortType pbSortType : list) {
            p pVar = new p();
            pVar.Ft(pbSortType.sort_type.intValue());
            pVar.NO(pbSortType.sort_name);
            arrayList.add(pVar);
        }
        this.kut.setVisibility(0);
        this.kut.setData(arrayList, i);
    }

    public void setOnSwitchChangeListener(SortSwitchButton.a aVar) {
        this.kkX = aVar;
    }

    public void W(View.OnClickListener onClickListener) {
        this.ehM = onClickListener;
    }
}
