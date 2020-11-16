package com.baidu.tieba.signall;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.R;
import com.baidu.tieba.signall.SignSingleModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes23.dex */
public class g extends BaseAdapter implements AbsListView.OnScrollListener, SignSingleModel.a {
    private c mOE;
    private boolean mOR;
    private SignAllForumActivity mPc;
    private ArrayList<d> ihK = new ArrayList<>();
    private HashMap<String, SignSingleModel> mPd = new HashMap<>();
    private boolean ixA = true;

    public g(SignAllForumActivity signAllForumActivity, TextView textView) {
        this.mPc = signAllForumActivity;
    }

    public void c(c cVar) {
        if (cVar != null) {
            this.mOE = cVar;
            this.ihK = cVar.dGS();
            if (this.ihK.size() == 0) {
                this.ixA = false;
            } else {
                this.ixA = true;
            }
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return getItem(i) instanceof com.baidu.tieba.signall.b ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.ixA) {
            return this.ihK.size();
        }
        return 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.ihK.size() > i) {
            return this.ihK.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    private View JO(int i) {
        if (i == 0) {
            View inflate = LayoutInflater.from(this.mPc.getPageContext().getPageActivity()).inflate(R.layout.signallforum_item, (ViewGroup) null);
            b bVar = new b();
            bVar.mPj = (BarImageView) inflate.findViewById(R.id.signallforum_item_avatar);
            bVar.mPj.setIsRound(false);
            bVar.mPj.setGifIconSupport(false);
            bVar.mPl = (TextView) inflate.findViewById(R.id.signallforum_item_name);
            bVar.fSM = (ImageView) inflate.findViewById(R.id.signallforum_item_level);
            bVar.mPo = (TextView) inflate.findViewById(R.id.signallforum_item_exp);
            bVar.mPp = (FrameLayout) inflate.findViewById(R.id.signallforum_item_res_container);
            bVar.mPq = (TextView) inflate.findViewById(R.id.signallforum_item_days);
            bVar.mPr = (RelativeLayout) inflate.findViewById(R.id.signallforum_item_resign_container);
            bVar.mPs = (ImageView) inflate.findViewById(R.id.signallforum_item_resign_icon);
            bVar.mPt = (ProgressBar) inflate.findViewById(R.id.signallforum_item_resign_progress);
            bVar.mPu = (TextView) inflate.findViewById(R.id.signallforum_item_resign_text);
            bVar.mPv = (TextView) inflate.findViewById(R.id.signallforum_item_error);
            bVar.mPk = (LinearLayout) inflate.findViewById(R.id.signallforum_item_level_container);
            bVar.mPw = (TextView) inflate.findViewById(R.id.signallforum_item_increaseexp);
            inflate.setTag(bVar);
            return inflate;
        }
        View inflate2 = LayoutInflater.from(this.mPc.getPageContext().getPageActivity()).inflate(R.layout.signallforum_header, (ViewGroup) null);
        a aVar = new a();
        aVar.mPh = (TextView) inflate2.findViewById(R.id.signallforum_head_title);
        aVar.mPi = (TextView) inflate2.findViewById(R.id.signallforum_head_res);
        inflate2.setTag(aVar);
        return inflate2;
    }

    private void a(View view, View view2, int i) {
        String str;
        this.mPc.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.mPc.getLayoutMode().onModeChanged(view);
        final b bVar = (b) view.getTag();
        final d dVar = (d) getItem(i);
        if (dVar != null) {
            String forumName = dVar.getForumName();
            if (forumName != null && forumName.length() > 8) {
                char[] charArray = forumName.toCharArray();
                int i2 = 0;
                for (int i3 = 0; i3 < charArray.length; i3++) {
                    if (StringUtils.isChinese(charArray[i3])) {
                        i2 += 2;
                    } else {
                        i2++;
                    }
                    if (i2 > 16) {
                        str = forumName.substring(0, i3) + StringHelper.STRING_MORE;
                        break;
                    }
                }
            }
            str = forumName;
            bVar.mPl.setText(str);
            ap.setImageResource(bVar.fSM, BitmapHelper.getSmallGradeResourceIdNew(dVar.dHf()));
            bVar.mPo.setText(dVar.dHg() + "/" + dVar.dHh());
            bVar.mPw.clearAnimation();
            if (dVar.bPe()) {
                bVar.mPk.setVisibility(0);
                bVar.mPv.setVisibility(8);
                bVar.mPq.setVisibility(0);
                bVar.mPr.setVisibility(8);
                bVar.mPq.setText(String.format(this.mPc.getPageContext().getString(R.string.signallforum_days), Integer.valueOf(dVar.dHe())));
                if (dVar.dHl()) {
                    bVar.mPo.setText(this.mPc.getPageContext().getString(R.string.signallforum_uplevel));
                    bVar.mPw.setVisibility(8);
                } else {
                    bVar.mPo.setText(dVar.dHg() + "/" + dVar.dHh());
                    bVar.mPw.setVisibility(0);
                }
                int dHk = dVar.dHk();
                if (dHk > 0) {
                    bVar.mPw.setVisibility(0);
                    bVar.mPw.setText("+" + dHk);
                } else {
                    bVar.mPw.setVisibility(8);
                }
            } else if (dVar.dHi()) {
                bVar.mPk.setVisibility(0);
                bVar.mPv.setVisibility(8);
                bVar.mPw.setVisibility(8);
                bVar.mPq.setVisibility(8);
                bVar.mPr.setVisibility(0);
                if (dVar.dHj()) {
                    bVar.mPs.setVisibility(4);
                    bVar.mPt.setVisibility(0);
                    bVar.mPu.setText(R.string.signallforum_resigning);
                } else {
                    bVar.mPs.setVisibility(0);
                    bVar.mPt.setVisibility(4);
                    bVar.mPu.setText(R.string.signallforum_resign);
                }
                bVar.mPr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.signall.g.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view3) {
                        if (!dVar.dHj()) {
                            bVar.mPs.setVisibility(4);
                            bVar.mPt.setVisibility(0);
                            bVar.mPu.setText(R.string.signallforum_resigning);
                            dVar.xj(true);
                            SignSingleModel signSingleModel = new SignSingleModel(g.this.mPc);
                            signSingleModel.a(g.this);
                            String str2 = dVar.getForumId() + "";
                            synchronized (g.this) {
                                g.this.mPd.put(str2, signSingleModel);
                            }
                            signSingleModel.gk(dVar.getForumName(), str2);
                            TiebaStatic.log("signall_resign_click");
                        }
                    }
                });
            } else {
                bVar.mPq.setVisibility(8);
                bVar.mPr.setVisibility(8);
                bVar.mPw.setVisibility(8);
                bVar.mPk.setVisibility(0);
                bVar.mPv.setVisibility(8);
            }
            String avatar = dVar.getAvatar();
            bVar.mPj.setTag(avatar);
            bVar.mPj.setPlaceHolder(1);
            bVar.mPj.startLoad(avatar, 10, false);
        }
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        a aVar;
        if (!this.ixA) {
            return cuG();
        }
        int itemViewType = getItemViewType(i);
        View JO = view == null ? JO(itemViewType) : view;
        if (itemViewType == 1) {
            if (JO.getTag() != null && (JO.getTag() instanceof a)) {
                view2 = JO;
                aVar = (a) JO.getTag();
            } else {
                View JO2 = JO(itemViewType);
                view2 = JO2;
                aVar = (a) JO2.getTag();
            }
            this.mPc.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
            this.mPc.getLayoutMode().onModeChanged(view2.findViewById(R.id.sign_all_forum_tip));
            aVar.mPh.setText(((com.baidu.tieba.signall.b) getItem(i)).getTitle());
            j(aVar.mPi, i);
            return view2;
        }
        if (JO.getTag() == null || !(JO.getTag() instanceof b)) {
            JO = JO(itemViewType);
        }
        a(JO, viewGroup, i);
        return JO;
    }

    private void j(TextView textView, int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        String format;
        int level = this.mOE == null ? 7 : this.mOE.getLevel();
        if (this.ihK == null || this.ihK.size() <= 0) {
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
        } else {
            Iterator<d> it = this.ihK.iterator();
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
            while (it.hasNext()) {
                d next = it.next();
                if (!TextUtils.isEmpty(next.getForumName())) {
                    if (next.dHf() >= level) {
                        if (next.bPe()) {
                            i5++;
                        } else {
                            i4++;
                        }
                    } else if (next.bPe()) {
                        i3++;
                    } else {
                        i2++;
                    }
                    i5 = i5;
                    i4 = i4;
                    i3 = i3;
                    i2 = i2;
                }
            }
        }
        if (i == 0 && i5 + i4 > 0) {
            format = String.format(this.mPc.getPageContext().getString(R.string.signallforum_res), Integer.valueOf(i5), Integer.valueOf(i4));
        } else {
            format = String.format(this.mPc.getPageContext().getString(R.string.signallforum_res), Integer.valueOf(i3), Integer.valueOf(i2));
        }
        textView.setText(format);
    }

    private View cuG() {
        View inflate = LayoutInflater.from(this.mPc.getPageContext().getPageActivity()).inflate(R.layout.sign_all_forum_nodata_item, (ViewGroup) null);
        NoDataView a2 = NoDataViewFactory.a(this.mPc.getPageContext().getPageActivity(), (LinearLayout) inflate.findViewById(R.id.sign_all_forum_no_data_view), NoDataViewFactory.c.a(NoDataViewFactory.ImgType.FINDBAR, this.mPc.getResources().getDimensionPixelSize(R.dimen.tbds90)), NoDataViewFactory.d.dS(null, this.mPc.getResources().getString(R.string.no_bar_attentioned)), null);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.mPc.getLayoutMode().setNightMode(skinType == 1);
        this.mPc.getLayoutMode().onModeChanged(inflate);
        a2.onChangeSkinType(this.mPc.getPageContext(), skinType);
        a2.setVisibility(0);
        a2.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        return inflate;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 0) {
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes23.dex */
    public class b {
        public ImageView fSM;
        public BarImageView mPj;
        public LinearLayout mPk;
        public TextView mPl;
        public TextView mPo;
        public FrameLayout mPp;
        public TextView mPq;
        public RelativeLayout mPr;
        public ImageView mPs;
        public ProgressBar mPt;
        public TextView mPu;
        public TextView mPv;
        public TextView mPw;

        b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes23.dex */
    public class a {
        public TextView mPh;
        public TextView mPi;

        a() {
        }
    }

    @Override // com.baidu.tieba.signall.SignSingleModel.a
    public void c(SignData signData) {
        String str = signData.forumId;
        synchronized (this) {
            this.mPd.remove(str);
        }
        a(str, true, signData, null);
    }

    @Override // com.baidu.tieba.signall.SignSingleModel.a
    public void gj(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            l.showToast(this.mPc.getPageContext().getPageActivity(), str2);
        }
        synchronized (this) {
            this.mPd.remove(str);
        }
        a(str, false, null, str2);
    }

    private void a(String str, boolean z, SignData signData, String str2) {
        int size = this.ihK.size();
        for (int i = 0; i < size; i++) {
            d dVar = this.ihK.get(i);
            if ((dVar.getForumId() + "").equals(str)) {
                dVar.xh(z);
                dVar.xi(!z);
                dVar.xj(false);
                if (z) {
                    dVar.JL(signData.count_sign_num);
                    dVar.JN(signData.sign_bonus_point);
                    dVar.JK(1);
                    TbadkApplication.getInst().addSignedForum(dVar.getForumName(), signData.sign_bonus_point, -1);
                    ArrayList<d> dGV = this.mOE.dGV();
                    if (dGV.contains(dVar)) {
                        dGV.remove(dVar);
                        this.mOE.dGU().add(dVar);
                    }
                } else {
                    dVar.setErrorMsg(str2);
                }
                if (!this.mOR) {
                    notifyDataSetChanged();
                    return;
                }
                return;
            }
        }
    }

    public void dHr() {
        this.mOR = true;
        synchronized (this) {
            try {
                for (Map.Entry<String, SignSingleModel> entry : this.mPd.entrySet()) {
                    entry.getValue().dHK();
                }
                this.mPd.clear();
            }
        }
    }
}
