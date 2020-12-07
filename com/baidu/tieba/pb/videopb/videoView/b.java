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
    private int bWc;
    private int bWd;
    private View.OnClickListener faK;
    private SortSwitchButton.a lEE;
    private n lOL;
    private SortSwitchButton lOz;
    private View mRootView;
    private TextView mdt;
    private TextView mdu;
    private int lOJ = 0;
    private int mdv = 0;
    private SortSwitchButton.a lIS = new SortSwitchButton.a() { // from class: com.baidu.tieba.pb.videopb.videoView.b.1
        @Override // com.baidu.tieba.view.SortSwitchButton.a
        public boolean Az(int i) {
            if (b.this.lEE != null) {
                return b.this.lEE.Az(i);
            }
            return true;
        }
    };
    private View.OnClickListener lOO = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.videoView.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.faK != null) {
                b.this.faK.onClick(view);
            }
            if (j.isNetWorkAvailable()) {
                if (view == null || !(view.getTag() instanceof Boolean) || ((Boolean) view.getTag()).booleanValue()) {
                    if (view != b.this.mdt) {
                        if (view == b.this.mdu) {
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
    private View.OnClickListener lOP = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.videoView.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.faK != null) {
                b.this.faK.onClick(view);
            }
        }
    };

    public void setSelection(int i) {
        this.mdv = i;
        if (i == 0) {
            this.mdt.setTypeface(Typeface.defaultFromStyle(1));
            this.mdu.setTypeface(Typeface.defaultFromStyle(0));
            this.mdt.setTextColor(this.bWc);
            this.mdu.setTextColor(this.bWd);
        } else if (i == 1) {
            this.mdt.setTypeface(Typeface.defaultFromStyle(0));
            this.mdu.setTypeface(Typeface.defaultFromStyle(1));
            this.mdt.setTextColor(this.bWd);
            this.mdu.setTextColor(this.bWc);
        }
    }

    public b(View view) {
        if (view != null) {
            this.mRootView = view;
            this.mdt = (TextView) this.mRootView.findViewById(R.id.all_reply);
            this.mdt.setOnClickListener(this.lOO);
            this.mdu = (TextView) this.mRootView.findViewById(R.id.owner_reply);
            this.mdu.setOnClickListener(this.lOO);
            this.lOz = (SortSwitchButton) this.mRootView.findViewById(R.id.video_pb_sort_switch_btn);
            this.lOz.setOnSwitchChangeListener(this.lIS);
            this.lOz.kj(2);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void vk(boolean z) {
        if (z) {
            setSelection(1);
        } else {
            setSelection(0);
        }
    }

    public void onChangeSkinType(int i) {
        ap.setBackgroundColor(this.mRootView, R.color.CAM_X0205);
        this.bWc = ap.getColor(R.color.CAM_X0105);
        this.bWd = ap.getColor(R.color.CAM_X0107);
        setSelection(this.mdv);
        this.lOz.onChangeSkinType();
    }

    public void a(n nVar) {
        this.lOL = nVar;
        if (nVar != null) {
            if (nVar.Wv == n.lCa) {
                this.mdt.setClickable(true);
                this.mdt.setText(TbadkCoreApplication.getInst().getString(R.string.all_reply));
                this.mdu.setVisibility(0);
                vk(nVar.lCf);
            }
            if (nVar.isDynamic) {
                this.mdu.setVisibility(8);
                this.lOz.setVisibility(8);
            } else {
                this.mdu.setVisibility(0);
                if (nVar.lCg != null) {
                    this.lOz.setVisibility(0);
                    int i = 0;
                    while (true) {
                        if (i >= nVar.lCg.size()) {
                            i = 0;
                            break;
                        } else if (nVar.lCg.get(i) != null && nVar.sortType == nVar.lCg.get(i).sort_type.intValue()) {
                            break;
                        } else {
                            i++;
                        }
                    }
                    p(nVar.lCg, i);
                }
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void p(List<PbSortType> list, int i) {
        if (y.isEmpty(list)) {
            this.lOz.setVisibility(8);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (PbSortType pbSortType : list) {
            p pVar = new p();
            pVar.KW(pbSortType.sort_type.intValue());
            pVar.TH(pbSortType.sort_name);
            arrayList.add(pVar);
        }
        this.lOz.setVisibility(0);
        this.lOz.setData(arrayList, i);
    }

    public void setOnSwitchChangeListener(SortSwitchButton.a aVar) {
        this.lEE = aVar;
    }

    public void X(View.OnClickListener onClickListener) {
        this.faK = onClickListener;
    }
}
