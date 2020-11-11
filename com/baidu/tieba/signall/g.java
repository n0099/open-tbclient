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
/* loaded from: classes24.dex */
public class g extends BaseAdapter implements AbsListView.OnScrollListener, SignSingleModel.a {
    private c mNL;
    private boolean mNY;
    private SignAllForumActivity mOj;
    private ArrayList<d> igW = new ArrayList<>();
    private HashMap<String, SignSingleModel> mOk = new HashMap<>();
    private boolean iwL = true;

    public g(SignAllForumActivity signAllForumActivity, TextView textView) {
        this.mOj = signAllForumActivity;
    }

    public void c(c cVar) {
        if (cVar != null) {
            this.mNL = cVar;
            this.igW = cVar.dHb();
            if (this.igW.size() == 0) {
                this.iwL = false;
            } else {
                this.iwL = true;
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
        if (this.iwL) {
            return this.igW.size();
        }
        return 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.igW.size() > i) {
            return this.igW.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    private View Jm(int i) {
        if (i == 0) {
            View inflate = LayoutInflater.from(this.mOj.getPageContext().getPageActivity()).inflate(R.layout.signallforum_item, (ViewGroup) null);
            b bVar = new b();
            bVar.mOq = (BarImageView) inflate.findViewById(R.id.signallforum_item_avatar);
            bVar.mOq.setIsRound(false);
            bVar.mOq.setGifIconSupport(false);
            bVar.mOs = (TextView) inflate.findViewById(R.id.signallforum_item_name);
            bVar.fTf = (ImageView) inflate.findViewById(R.id.signallforum_item_level);
            bVar.mOt = (TextView) inflate.findViewById(R.id.signallforum_item_exp);
            bVar.mOu = (FrameLayout) inflate.findViewById(R.id.signallforum_item_res_container);
            bVar.mOv = (TextView) inflate.findViewById(R.id.signallforum_item_days);
            bVar.mOw = (RelativeLayout) inflate.findViewById(R.id.signallforum_item_resign_container);
            bVar.mOx = (ImageView) inflate.findViewById(R.id.signallforum_item_resign_icon);
            bVar.mOy = (ProgressBar) inflate.findViewById(R.id.signallforum_item_resign_progress);
            bVar.mOz = (TextView) inflate.findViewById(R.id.signallforum_item_resign_text);
            bVar.mOA = (TextView) inflate.findViewById(R.id.signallforum_item_error);
            bVar.mOr = (LinearLayout) inflate.findViewById(R.id.signallforum_item_level_container);
            bVar.mOB = (TextView) inflate.findViewById(R.id.signallforum_item_increaseexp);
            inflate.setTag(bVar);
            return inflate;
        }
        View inflate2 = LayoutInflater.from(this.mOj.getPageContext().getPageActivity()).inflate(R.layout.signallforum_header, (ViewGroup) null);
        a aVar = new a();
        aVar.mOo = (TextView) inflate2.findViewById(R.id.signallforum_head_title);
        aVar.mOp = (TextView) inflate2.findViewById(R.id.signallforum_head_res);
        inflate2.setTag(aVar);
        return inflate2;
    }

    private void a(View view, View view2, int i) {
        String str;
        this.mOj.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.mOj.getLayoutMode().onModeChanged(view);
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
            bVar.mOs.setText(str);
            ap.setImageResource(bVar.fTf, BitmapHelper.getSmallGradeResourceIdNew(dVar.dHo()));
            bVar.mOt.setText(dVar.dHp() + "/" + dVar.dHq());
            bVar.mOB.clearAnimation();
            if (dVar.bPL()) {
                bVar.mOr.setVisibility(0);
                bVar.mOA.setVisibility(8);
                bVar.mOv.setVisibility(0);
                bVar.mOw.setVisibility(8);
                bVar.mOv.setText(String.format(this.mOj.getPageContext().getString(R.string.signallforum_days), Integer.valueOf(dVar.dHn())));
                if (dVar.dHu()) {
                    bVar.mOt.setText(this.mOj.getPageContext().getString(R.string.signallforum_uplevel));
                    bVar.mOB.setVisibility(8);
                } else {
                    bVar.mOt.setText(dVar.dHp() + "/" + dVar.dHq());
                    bVar.mOB.setVisibility(0);
                }
                int dHt = dVar.dHt();
                if (dHt > 0) {
                    bVar.mOB.setVisibility(0);
                    bVar.mOB.setText("+" + dHt);
                } else {
                    bVar.mOB.setVisibility(8);
                }
            } else if (dVar.dHr()) {
                bVar.mOr.setVisibility(0);
                bVar.mOA.setVisibility(8);
                bVar.mOB.setVisibility(8);
                bVar.mOv.setVisibility(8);
                bVar.mOw.setVisibility(0);
                if (dVar.dHs()) {
                    bVar.mOx.setVisibility(4);
                    bVar.mOy.setVisibility(0);
                    bVar.mOz.setText(R.string.signallforum_resigning);
                } else {
                    bVar.mOx.setVisibility(0);
                    bVar.mOy.setVisibility(4);
                    bVar.mOz.setText(R.string.signallforum_resign);
                }
                bVar.mOw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.signall.g.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view3) {
                        if (!dVar.dHs()) {
                            bVar.mOx.setVisibility(4);
                            bVar.mOy.setVisibility(0);
                            bVar.mOz.setText(R.string.signallforum_resigning);
                            dVar.xf(true);
                            SignSingleModel signSingleModel = new SignSingleModel(g.this.mOj);
                            signSingleModel.a(g.this);
                            String str2 = dVar.getForumId() + "";
                            synchronized (g.this) {
                                g.this.mOk.put(str2, signSingleModel);
                            }
                            signSingleModel.gk(dVar.getForumName(), str2);
                            TiebaStatic.log("signall_resign_click");
                        }
                    }
                });
            } else {
                bVar.mOv.setVisibility(8);
                bVar.mOw.setVisibility(8);
                bVar.mOB.setVisibility(8);
                bVar.mOr.setVisibility(0);
                bVar.mOA.setVisibility(8);
            }
            String avatar = dVar.getAvatar();
            bVar.mOq.setTag(avatar);
            bVar.mOq.setPlaceHolder(1);
            bVar.mOq.startLoad(avatar, 10, false);
        }
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        a aVar;
        if (!this.iwL) {
            return cvd();
        }
        int itemViewType = getItemViewType(i);
        View Jm = view == null ? Jm(itemViewType) : view;
        if (itemViewType == 1) {
            if (Jm.getTag() != null && (Jm.getTag() instanceof a)) {
                view2 = Jm;
                aVar = (a) Jm.getTag();
            } else {
                View Jm2 = Jm(itemViewType);
                view2 = Jm2;
                aVar = (a) Jm2.getTag();
            }
            this.mOj.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
            this.mOj.getLayoutMode().onModeChanged(view2.findViewById(R.id.sign_all_forum_tip));
            aVar.mOo.setText(((com.baidu.tieba.signall.b) getItem(i)).getTitle());
            j(aVar.mOp, i);
            return view2;
        }
        if (Jm.getTag() == null || !(Jm.getTag() instanceof b)) {
            Jm = Jm(itemViewType);
        }
        a(Jm, viewGroup, i);
        return Jm;
    }

    private void j(TextView textView, int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        String format;
        int level = this.mNL == null ? 7 : this.mNL.getLevel();
        if (this.igW == null || this.igW.size() <= 0) {
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
        } else {
            Iterator<d> it = this.igW.iterator();
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
            while (it.hasNext()) {
                d next = it.next();
                if (!TextUtils.isEmpty(next.getForumName())) {
                    if (next.dHo() >= level) {
                        if (next.bPL()) {
                            i5++;
                        } else {
                            i4++;
                        }
                    } else if (next.bPL()) {
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
            format = String.format(this.mOj.getPageContext().getString(R.string.signallforum_res), Integer.valueOf(i5), Integer.valueOf(i4));
        } else {
            format = String.format(this.mOj.getPageContext().getString(R.string.signallforum_res), Integer.valueOf(i3), Integer.valueOf(i2));
        }
        textView.setText(format);
    }

    private View cvd() {
        View inflate = LayoutInflater.from(this.mOj.getPageContext().getPageActivity()).inflate(R.layout.sign_all_forum_nodata_item, (ViewGroup) null);
        NoDataView a2 = NoDataViewFactory.a(this.mOj.getPageContext().getPageActivity(), (LinearLayout) inflate.findViewById(R.id.sign_all_forum_no_data_view), NoDataViewFactory.c.a(NoDataViewFactory.ImgType.FINDBAR, this.mOj.getResources().getDimensionPixelSize(R.dimen.tbds90)), NoDataViewFactory.d.dS(null, this.mOj.getResources().getString(R.string.no_bar_attentioned)), null);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.mOj.getLayoutMode().setNightMode(skinType == 1);
        this.mOj.getLayoutMode().onModeChanged(inflate);
        a2.onChangeSkinType(this.mOj.getPageContext(), skinType);
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
    /* loaded from: classes24.dex */
    public class b {
        public ImageView fTf;
        public TextView mOA;
        public TextView mOB;
        public BarImageView mOq;
        public LinearLayout mOr;
        public TextView mOs;
        public TextView mOt;
        public FrameLayout mOu;
        public TextView mOv;
        public RelativeLayout mOw;
        public ImageView mOx;
        public ProgressBar mOy;
        public TextView mOz;

        b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes24.dex */
    public class a {
        public TextView mOo;
        public TextView mOp;

        a() {
        }
    }

    @Override // com.baidu.tieba.signall.SignSingleModel.a
    public void c(SignData signData) {
        String str = signData.forumId;
        synchronized (this) {
            this.mOk.remove(str);
        }
        a(str, true, signData, null);
    }

    @Override // com.baidu.tieba.signall.SignSingleModel.a
    public void gj(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            l.showToast(this.mOj.getPageContext().getPageActivity(), str2);
        }
        synchronized (this) {
            this.mOk.remove(str);
        }
        a(str, false, null, str2);
    }

    private void a(String str, boolean z, SignData signData, String str2) {
        int size = this.igW.size();
        for (int i = 0; i < size; i++) {
            d dVar = this.igW.get(i);
            if ((dVar.getForumId() + "").equals(str)) {
                dVar.xd(z);
                dVar.xe(!z);
                dVar.xf(false);
                if (z) {
                    dVar.Jj(signData.count_sign_num);
                    dVar.Jl(signData.sign_bonus_point);
                    dVar.Ji(1);
                    TbadkApplication.getInst().addSignedForum(dVar.getForumName(), signData.sign_bonus_point, -1);
                    ArrayList<d> dHe = this.mNL.dHe();
                    if (dHe.contains(dVar)) {
                        dHe.remove(dVar);
                        this.mNL.dHd().add(dVar);
                    }
                } else {
                    dVar.setErrorMsg(str2);
                }
                if (!this.mNY) {
                    notifyDataSetChanged();
                    return;
                }
                return;
            }
        }
    }

    public void dHA() {
        this.mNY = true;
        synchronized (this) {
            try {
                for (Map.Entry<String, SignSingleModel> entry : this.mOk.entrySet()) {
                    entry.getValue().dHT();
                }
                this.mOk.clear();
            }
        }
    }
}
