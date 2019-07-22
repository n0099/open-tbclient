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
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.R;
import com.baidu.tieba.signall.SignSingleModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes6.dex */
public class g extends BaseAdapter implements AbsListView.OnScrollListener, SignSingleModel.a {
    private c iWK;
    private SignAllForumActivity iXe;
    private boolean isDestory;
    private ArrayList<d> eUx = new ArrayList<>();
    private HashMap<String, SignSingleModel> iXf = new HashMap<>();
    private boolean ffW = true;

    public g(SignAllForumActivity signAllForumActivity, TextView textView) {
        this.iXe = signAllForumActivity;
    }

    public void c(c cVar) {
        if (cVar != null) {
            this.iWK = cVar;
            this.eUx = cVar.cmI();
            if (this.eUx.size() == 0) {
                this.ffW = false;
            } else {
                this.ffW = true;
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
        if (this.ffW) {
            return this.eUx.size();
        }
        return 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.eUx.size() > i) {
            return this.eUx.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    private View AO(int i) {
        if (i == 0) {
            View inflate = LayoutInflater.from(this.iXe.getPageContext().getPageActivity()).inflate(R.layout.signallforum_item, (ViewGroup) null);
            b bVar = new b();
            bVar.iXl = (BarImageView) inflate.findViewById(R.id.signallforum_item_avatar);
            bVar.iXl.setIsRound(false);
            bVar.iXl.setGifIconSupport(false);
            bVar.iXn = (TextView) inflate.findViewById(R.id.signallforum_item_name);
            bVar.iXo = (ImageView) inflate.findViewById(R.id.signallforum_item_level);
            bVar.iXp = (TextView) inflate.findViewById(R.id.signallforum_item_exp);
            bVar.iXq = (FrameLayout) inflate.findViewById(R.id.signallforum_item_res_container);
            bVar.iXr = (TextView) inflate.findViewById(R.id.signallforum_item_days);
            bVar.iXs = (RelativeLayout) inflate.findViewById(R.id.signallforum_item_resign_container);
            bVar.iXt = (ImageView) inflate.findViewById(R.id.signallforum_item_resign_icon);
            bVar.iXu = (ProgressBar) inflate.findViewById(R.id.signallforum_item_resign_progress);
            bVar.iXv = (TextView) inflate.findViewById(R.id.signallforum_item_resign_text);
            bVar.iXw = (TextView) inflate.findViewById(R.id.signallforum_item_error);
            bVar.iXm = (LinearLayout) inflate.findViewById(R.id.signallforum_item_level_container);
            bVar.iXx = (TextView) inflate.findViewById(R.id.signallforum_item_increaseexp);
            inflate.setTag(bVar);
            return inflate;
        }
        View inflate2 = LayoutInflater.from(this.iXe.getPageContext().getPageActivity()).inflate(R.layout.signallforum_header, (ViewGroup) null);
        a aVar = new a();
        aVar.iXj = (TextView) inflate2.findViewById(R.id.signallforum_head_title);
        aVar.iXk = (TextView) inflate2.findViewById(R.id.signallforum_head_res);
        inflate2.setTag(aVar);
        return inflate2;
    }

    private void a(View view, View view2, int i) {
        String str;
        this.iXe.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.iXe.getLayoutMode().onModeChanged(view);
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
                        str = forumName.substring(0, i3) + "...";
                        break;
                    }
                }
            }
            str = forumName;
            bVar.iXn.setText(str);
            am.c(bVar.iXo, BitmapHelper.getSmallGradeResourceIdNew(dVar.cmV()));
            bVar.iXp.setText(dVar.cmW() + "/" + dVar.cmX());
            bVar.iXx.clearAnimation();
            if (dVar.aJX()) {
                bVar.iXm.setVisibility(0);
                bVar.iXw.setVisibility(8);
                bVar.iXr.setVisibility(0);
                bVar.iXs.setVisibility(8);
                bVar.iXr.setText(String.format(this.iXe.getPageContext().getString(R.string.signallforum_days), Integer.valueOf(dVar.cmU())));
                if (dVar.cnb()) {
                    bVar.iXp.setText(this.iXe.getPageContext().getString(R.string.signallforum_uplevel));
                    bVar.iXx.setVisibility(8);
                } else {
                    bVar.iXp.setText(dVar.cmW() + "/" + dVar.cmX());
                    bVar.iXx.setVisibility(0);
                }
                int cna = dVar.cna();
                if (cna > 0) {
                    bVar.iXx.setVisibility(0);
                    bVar.iXx.setText("+" + cna);
                } else {
                    bVar.iXx.setVisibility(8);
                }
            } else if (dVar.cmY()) {
                bVar.iXm.setVisibility(0);
                bVar.iXw.setVisibility(8);
                bVar.iXx.setVisibility(8);
                bVar.iXr.setVisibility(8);
                bVar.iXs.setVisibility(0);
                if (dVar.cmZ()) {
                    bVar.iXt.setVisibility(4);
                    bVar.iXu.setVisibility(0);
                    bVar.iXv.setText(R.string.signallforum_resigning);
                } else {
                    bVar.iXt.setVisibility(0);
                    bVar.iXu.setVisibility(4);
                    bVar.iXv.setText(R.string.signallforum_resign);
                }
                bVar.iXs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.signall.g.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view3) {
                        if (!dVar.cmZ()) {
                            bVar.iXt.setVisibility(4);
                            bVar.iXu.setVisibility(0);
                            bVar.iXv.setText(R.string.signallforum_resigning);
                            dVar.qQ(true);
                            SignSingleModel signSingleModel = new SignSingleModel(g.this.iXe);
                            signSingleModel.a(g.this);
                            String str2 = dVar.getForumId() + "";
                            synchronized (g.this) {
                                g.this.iXf.put(str2, signSingleModel);
                            }
                            signSingleModel.eg(dVar.getForumName(), str2);
                            TiebaStatic.log("signall_resign_click");
                        }
                    }
                });
            } else {
                bVar.iXr.setVisibility(8);
                bVar.iXs.setVisibility(8);
                bVar.iXx.setVisibility(8);
                bVar.iXm.setVisibility(0);
                bVar.iXw.setVisibility(8);
            }
            String avatar = dVar.getAvatar();
            bVar.iXl.setTag(avatar);
            bVar.iXl.startLoad(avatar, 10, false);
        }
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        a aVar;
        if (!this.ffW) {
            return bil();
        }
        int itemViewType = getItemViewType(i);
        View AO = view == null ? AO(itemViewType) : view;
        if (itemViewType == 1) {
            if (AO.getTag() != null && (AO.getTag() instanceof a)) {
                view2 = AO;
                aVar = (a) AO.getTag();
            } else {
                View AO2 = AO(itemViewType);
                view2 = AO2;
                aVar = (a) AO2.getTag();
            }
            this.iXe.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
            this.iXe.getLayoutMode().onModeChanged(view2.findViewById(R.id.sign_all_forum_tip));
            aVar.iXj.setText(((com.baidu.tieba.signall.b) getItem(i)).getTitle());
            o(aVar.iXk, i);
            return view2;
        }
        if (AO.getTag() == null || !(AO.getTag() instanceof b)) {
            AO = AO(itemViewType);
        }
        a(AO, viewGroup, i);
        return AO;
    }

    private void o(TextView textView, int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        String format;
        int level = this.iWK == null ? 7 : this.iWK.getLevel();
        if (this.eUx == null || this.eUx.size() <= 0) {
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
        } else {
            Iterator<d> it = this.eUx.iterator();
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
            while (it.hasNext()) {
                d next = it.next();
                if (!TextUtils.isEmpty(next.getForumName())) {
                    if (next.cmV() >= level) {
                        if (next.aJX()) {
                            i5++;
                        } else {
                            i4++;
                        }
                    } else if (next.aJX()) {
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
            format = String.format(this.iXe.getPageContext().getString(R.string.signallforum_res), Integer.valueOf(i5), Integer.valueOf(i4));
        } else {
            format = String.format(this.iXe.getPageContext().getString(R.string.signallforum_res), Integer.valueOf(i3), Integer.valueOf(i2));
        }
        textView.setText(format);
    }

    private View bil() {
        View inflate = LayoutInflater.from(this.iXe.getPageContext().getPageActivity()).inflate(R.layout.sign_all_forum_nodata_item, (ViewGroup) null);
        NoDataView a2 = NoDataViewFactory.a(this.iXe.getPageContext().getPageActivity(), (LinearLayout) inflate.findViewById(R.id.sign_all_forum_no_data_view), NoDataViewFactory.c.a(NoDataViewFactory.ImgType.SINGALL, 0), NoDataViewFactory.d.ag(R.string.sign_all_forum_nodata_tip, R.string.sign_all_forum_nodata_guide), null);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.iXe.getLayoutMode().setNightMode(skinType == 1);
        this.iXe.getLayoutMode().onModeChanged(inflate);
        a2.onChangeSkinType(this.iXe.getPageContext(), skinType);
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
    /* loaded from: classes6.dex */
    public class b {
        public BarImageView iXl;
        public LinearLayout iXm;
        public TextView iXn;
        public ImageView iXo;
        public TextView iXp;
        public FrameLayout iXq;
        public TextView iXr;
        public RelativeLayout iXs;
        public ImageView iXt;
        public ProgressBar iXu;
        public TextView iXv;
        public TextView iXw;
        public TextView iXx;

        b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class a {
        public TextView iXj;
        public TextView iXk;

        a() {
        }
    }

    @Override // com.baidu.tieba.signall.SignSingleModel.a
    public void b(SignData signData) {
        String str = signData.forumId;
        synchronized (this) {
            this.iXf.remove(str);
        }
        a(str, true, signData, null);
    }

    @Override // com.baidu.tieba.signall.SignSingleModel.a
    public void ef(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            l.showToast(this.iXe.getPageContext().getPageActivity(), str2);
        }
        synchronized (this) {
            this.iXf.remove(str);
        }
        a(str, false, null, str2);
    }

    private void a(String str, boolean z, SignData signData, String str2) {
        int size = this.eUx.size();
        for (int i = 0; i < size; i++) {
            d dVar = this.eUx.get(i);
            if ((dVar.getForumId() + "").equals(str)) {
                dVar.qO(z);
                dVar.qP(!z);
                dVar.qQ(false);
                if (z) {
                    dVar.AL(signData.count_sign_num);
                    dVar.AN(signData.sign_bonus_point);
                    dVar.AK(1);
                    TbadkApplication.getInst().addSignedForum(dVar.getForumName(), signData.sign_bonus_point, -1);
                    ArrayList<d> cmL = this.iWK.cmL();
                    if (cmL.contains(dVar)) {
                        cmL.remove(dVar);
                        this.iWK.cmK().add(dVar);
                    }
                } else {
                    dVar.setErrorMsg(str2);
                }
                if (!this.isDestory) {
                    notifyDataSetChanged();
                    return;
                }
                return;
            }
        }
    }

    public void cnh() {
        this.isDestory = true;
        synchronized (this) {
            try {
                for (Map.Entry<String, SignSingleModel> entry : this.iXf.entrySet()) {
                    entry.getValue().cnA();
                }
                this.iXf.clear();
            }
        }
    }
}
