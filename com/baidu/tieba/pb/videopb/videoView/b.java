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
    private SortSwitchButton.a lEG;
    private SortSwitchButton lOB;
    private n lON;
    private View mRootView;
    private TextView mdv;
    private TextView mdw;
    private int lOL = 0;
    private int mdx = 0;
    private SortSwitchButton.a lIU = new SortSwitchButton.a() { // from class: com.baidu.tieba.pb.videopb.videoView.b.1
        @Override // com.baidu.tieba.view.SortSwitchButton.a
        public boolean Az(int i) {
            if (b.this.lEG != null) {
                return b.this.lEG.Az(i);
            }
            return true;
        }
    };
    private View.OnClickListener lOQ = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.videoView.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.faK != null) {
                b.this.faK.onClick(view);
            }
            if (j.isNetWorkAvailable()) {
                if (view == null || !(view.getTag() instanceof Boolean) || ((Boolean) view.getTag()).booleanValue()) {
                    if (view != b.this.mdv) {
                        if (view == b.this.mdw) {
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
    private View.OnClickListener lOR = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.videoView.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.faK != null) {
                b.this.faK.onClick(view);
            }
        }
    };

    public void setSelection(int i) {
        this.mdx = i;
        if (i == 0) {
            this.mdv.setTypeface(Typeface.defaultFromStyle(1));
            this.mdw.setTypeface(Typeface.defaultFromStyle(0));
            this.mdv.setTextColor(this.bWc);
            this.mdw.setTextColor(this.bWd);
        } else if (i == 1) {
            this.mdv.setTypeface(Typeface.defaultFromStyle(0));
            this.mdw.setTypeface(Typeface.defaultFromStyle(1));
            this.mdv.setTextColor(this.bWd);
            this.mdw.setTextColor(this.bWc);
        }
    }

    public b(View view) {
        if (view != null) {
            this.mRootView = view;
            this.mdv = (TextView) this.mRootView.findViewById(R.id.all_reply);
            this.mdv.setOnClickListener(this.lOQ);
            this.mdw = (TextView) this.mRootView.findViewById(R.id.owner_reply);
            this.mdw.setOnClickListener(this.lOQ);
            this.lOB = (SortSwitchButton) this.mRootView.findViewById(R.id.video_pb_sort_switch_btn);
            this.lOB.setOnSwitchChangeListener(this.lIU);
            this.lOB.kj(2);
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
        setSelection(this.mdx);
        this.lOB.onChangeSkinType();
    }

    public void a(n nVar) {
        this.lON = nVar;
        if (nVar != null) {
            if (nVar.Wv == n.lCc) {
                this.mdv.setClickable(true);
                this.mdv.setText(TbadkCoreApplication.getInst().getString(R.string.all_reply));
                this.mdw.setVisibility(0);
                vk(nVar.lCh);
            }
            if (nVar.isDynamic) {
                this.mdw.setVisibility(8);
                this.lOB.setVisibility(8);
            } else {
                this.mdw.setVisibility(0);
                if (nVar.lCi != null) {
                    this.lOB.setVisibility(0);
                    int i = 0;
                    while (true) {
                        if (i >= nVar.lCi.size()) {
                            i = 0;
                            break;
                        } else if (nVar.lCi.get(i) != null && nVar.sortType == nVar.lCi.get(i).sort_type.intValue()) {
                            break;
                        } else {
                            i++;
                        }
                    }
                    p(nVar.lCi, i);
                }
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void p(List<PbSortType> list, int i) {
        if (y.isEmpty(list)) {
            this.lOB.setVisibility(8);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (PbSortType pbSortType : list) {
            p pVar = new p();
            pVar.KW(pbSortType.sort_type.intValue());
            pVar.TH(pbSortType.sort_name);
            arrayList.add(pVar);
        }
        this.lOB.setVisibility(0);
        this.lOB.setData(arrayList, i);
    }

    public void setOnSwitchChangeListener(SortSwitchButton.a aVar) {
        this.lEG = aVar;
    }

    public void X(View.OnClickListener onClickListener) {
        this.faK = onClickListener;
    }
}
