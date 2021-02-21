package com.baidu.tieba.pb.videopb.videoView;

import android.graphics.Typeface;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.data.o;
import com.baidu.tieba.tbadkCore.data.r;
import com.baidu.tieba.view.SortSwitchButton;
import java.util.ArrayList;
import java.util.List;
import tbclient.PbPage.PbSortType;
/* loaded from: classes2.dex */
public class b {
    private int caN;
    private int caO;
    private View.OnClickListener fhT;
    private SortSwitchButton.a lOt;
    private o lYG;
    private SortSwitchButton lYu;
    private View mRootView;
    private TextView mnt;
    private TextView mnu;
    private int lYE = 0;
    private int mnv = 0;
    private SortSwitchButton.a lSQ = new SortSwitchButton.a() { // from class: com.baidu.tieba.pb.videopb.videoView.b.1
        @Override // com.baidu.tieba.view.SortSwitchButton.a
        public boolean zp(int i) {
            if (b.this.lOt != null) {
                return b.this.lOt.zp(i);
            }
            return true;
        }
    };
    private View.OnClickListener lYJ = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.videoView.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.fhT != null) {
                b.this.fhT.onClick(view);
            }
            if (j.isNetWorkAvailable()) {
                if (view == null || !(view.getTag() instanceof Boolean) || ((Boolean) view.getTag()).booleanValue()) {
                    if (view != b.this.mnt) {
                        if (view == b.this.mnu) {
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
    private View.OnClickListener lYK = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.videoView.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.fhT != null) {
                b.this.fhT.onClick(view);
            }
        }
    };

    public void setSelection(int i) {
        this.mnv = i;
        if (i == 0) {
            this.mnt.setTypeface(Typeface.defaultFromStyle(1));
            this.mnu.setTypeface(Typeface.defaultFromStyle(0));
            this.mnt.setTextColor(this.caN);
            this.mnu.setTextColor(this.caO);
        } else if (i == 1) {
            this.mnt.setTypeface(Typeface.defaultFromStyle(0));
            this.mnu.setTypeface(Typeface.defaultFromStyle(1));
            this.mnt.setTextColor(this.caO);
            this.mnu.setTextColor(this.caN);
        }
    }

    public b(View view) {
        if (view != null) {
            this.mRootView = view;
            this.mnt = (TextView) this.mRootView.findViewById(R.id.all_reply);
            this.mnt.setOnClickListener(this.lYJ);
            this.mnu = (TextView) this.mRootView.findViewById(R.id.owner_reply);
            this.mnu.setOnClickListener(this.lYJ);
            this.lYu = (SortSwitchButton) this.mRootView.findViewById(R.id.video_pb_sort_switch_btn);
            this.lYu.setOnSwitchChangeListener(this.lSQ);
            this.lYu.iF(2);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void vw(boolean z) {
        if (z) {
            setSelection(1);
        } else {
            setSelection(0);
        }
    }

    public void onChangeSkinType(int i) {
        ap.setBackgroundColor(this.mRootView, R.color.CAM_X0205);
        this.caN = ap.getColor(R.color.CAM_X0105);
        this.caO = ap.getColor(R.color.CAM_X0107);
        setSelection(this.mnv);
        this.lYu.onChangeSkinType();
    }

    public void a(o oVar) {
        this.lYG = oVar;
        if (oVar != null) {
            if (oVar.Wm == o.lLF) {
                this.mnt.setClickable(true);
                this.mnt.setText(TbadkCoreApplication.getInst().getString(R.string.all_reply));
                this.mnu.setVisibility(0);
                vw(oVar.lLK);
            }
            if (oVar.isDynamic) {
                this.mnu.setVisibility(8);
                this.lYu.setVisibility(8);
            } else {
                this.mnu.setVisibility(0);
                if (oVar.lLL != null) {
                    this.lYu.setVisibility(0);
                    int i = 0;
                    while (true) {
                        if (i >= oVar.lLL.size()) {
                            i = 0;
                            break;
                        } else if (oVar.lLL.get(i) != null && oVar.sortType == oVar.lLL.get(i).sort_type.intValue()) {
                            break;
                        } else {
                            i++;
                        }
                    }
                    p(oVar.lLL, i);
                }
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void p(List<PbSortType> list, int i) {
        if (y.isEmpty(list)) {
            this.lYu.setVisibility(8);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (PbSortType pbSortType : list) {
            r rVar = new r();
            rVar.JF(pbSortType.sort_type.intValue());
            rVar.Tr(pbSortType.sort_name);
            arrayList.add(rVar);
        }
        this.lYu.setVisibility(0);
        this.lYu.setData(arrayList, i);
    }

    public void setOnSwitchChangeListener(SortSwitchButton.a aVar) {
        this.lOt = aVar;
    }

    public void Z(View.OnClickListener onClickListener) {
        this.fhT = onClickListener;
    }
}
