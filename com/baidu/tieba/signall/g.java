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
    private c iXO;
    private SignAllForumActivity iYi;
    private boolean isDestory;
    private ArrayList<d> eUE = new ArrayList<>();
    private HashMap<String, SignSingleModel> iYj = new HashMap<>();
    private boolean fgw = true;

    public g(SignAllForumActivity signAllForumActivity, TextView textView) {
        this.iYi = signAllForumActivity;
    }

    public void c(c cVar) {
        if (cVar != null) {
            this.iXO = cVar;
            this.eUE = cVar.cna();
            if (this.eUE.size() == 0) {
                this.fgw = false;
            } else {
                this.fgw = true;
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
        if (this.fgw) {
            return this.eUE.size();
        }
        return 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.eUE.size() > i) {
            return this.eUE.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    private View AQ(int i) {
        if (i == 0) {
            View inflate = LayoutInflater.from(this.iYi.getPageContext().getPageActivity()).inflate(R.layout.signallforum_item, (ViewGroup) null);
            b bVar = new b();
            bVar.iYp = (BarImageView) inflate.findViewById(R.id.signallforum_item_avatar);
            bVar.iYp.setIsRound(false);
            bVar.iYp.setGifIconSupport(false);
            bVar.iYr = (TextView) inflate.findViewById(R.id.signallforum_item_name);
            bVar.iYs = (ImageView) inflate.findViewById(R.id.signallforum_item_level);
            bVar.iYt = (TextView) inflate.findViewById(R.id.signallforum_item_exp);
            bVar.iYu = (FrameLayout) inflate.findViewById(R.id.signallforum_item_res_container);
            bVar.iYv = (TextView) inflate.findViewById(R.id.signallforum_item_days);
            bVar.iYw = (RelativeLayout) inflate.findViewById(R.id.signallforum_item_resign_container);
            bVar.iYx = (ImageView) inflate.findViewById(R.id.signallforum_item_resign_icon);
            bVar.iYy = (ProgressBar) inflate.findViewById(R.id.signallforum_item_resign_progress);
            bVar.iYz = (TextView) inflate.findViewById(R.id.signallforum_item_resign_text);
            bVar.iYA = (TextView) inflate.findViewById(R.id.signallforum_item_error);
            bVar.iYq = (LinearLayout) inflate.findViewById(R.id.signallforum_item_level_container);
            bVar.iYB = (TextView) inflate.findViewById(R.id.signallforum_item_increaseexp);
            inflate.setTag(bVar);
            return inflate;
        }
        View inflate2 = LayoutInflater.from(this.iYi.getPageContext().getPageActivity()).inflate(R.layout.signallforum_header, (ViewGroup) null);
        a aVar = new a();
        aVar.iYn = (TextView) inflate2.findViewById(R.id.signallforum_head_title);
        aVar.iYo = (TextView) inflate2.findViewById(R.id.signallforum_head_res);
        inflate2.setTag(aVar);
        return inflate2;
    }

    private void a(View view, View view2, int i) {
        String str;
        this.iYi.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.iYi.getLayoutMode().onModeChanged(view);
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
            bVar.iYr.setText(str);
            am.c(bVar.iYs, BitmapHelper.getSmallGradeResourceIdNew(dVar.cnn()));
            bVar.iYt.setText(dVar.cno() + "/" + dVar.cnp());
            bVar.iYB.clearAnimation();
            if (dVar.aJZ()) {
                bVar.iYq.setVisibility(0);
                bVar.iYA.setVisibility(8);
                bVar.iYv.setVisibility(0);
                bVar.iYw.setVisibility(8);
                bVar.iYv.setText(String.format(this.iYi.getPageContext().getString(R.string.signallforum_days), Integer.valueOf(dVar.cnm())));
                if (dVar.cnt()) {
                    bVar.iYt.setText(this.iYi.getPageContext().getString(R.string.signallforum_uplevel));
                    bVar.iYB.setVisibility(8);
                } else {
                    bVar.iYt.setText(dVar.cno() + "/" + dVar.cnp());
                    bVar.iYB.setVisibility(0);
                }
                int cns = dVar.cns();
                if (cns > 0) {
                    bVar.iYB.setVisibility(0);
                    bVar.iYB.setText("+" + cns);
                } else {
                    bVar.iYB.setVisibility(8);
                }
            } else if (dVar.cnq()) {
                bVar.iYq.setVisibility(0);
                bVar.iYA.setVisibility(8);
                bVar.iYB.setVisibility(8);
                bVar.iYv.setVisibility(8);
                bVar.iYw.setVisibility(0);
                if (dVar.cnr()) {
                    bVar.iYx.setVisibility(4);
                    bVar.iYy.setVisibility(0);
                    bVar.iYz.setText(R.string.signallforum_resigning);
                } else {
                    bVar.iYx.setVisibility(0);
                    bVar.iYy.setVisibility(4);
                    bVar.iYz.setText(R.string.signallforum_resign);
                }
                bVar.iYw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.signall.g.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view3) {
                        if (!dVar.cnr()) {
                            bVar.iYx.setVisibility(4);
                            bVar.iYy.setVisibility(0);
                            bVar.iYz.setText(R.string.signallforum_resigning);
                            dVar.qR(true);
                            SignSingleModel signSingleModel = new SignSingleModel(g.this.iYi);
                            signSingleModel.a(g.this);
                            String str2 = dVar.getForumId() + "";
                            synchronized (g.this) {
                                g.this.iYj.put(str2, signSingleModel);
                            }
                            signSingleModel.eg(dVar.getForumName(), str2);
                            TiebaStatic.log("signall_resign_click");
                        }
                    }
                });
            } else {
                bVar.iYv.setVisibility(8);
                bVar.iYw.setVisibility(8);
                bVar.iYB.setVisibility(8);
                bVar.iYq.setVisibility(0);
                bVar.iYA.setVisibility(8);
            }
            String avatar = dVar.getAvatar();
            bVar.iYp.setTag(avatar);
            bVar.iYp.startLoad(avatar, 10, false);
        }
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        a aVar;
        if (!this.fgw) {
            return bis();
        }
        int itemViewType = getItemViewType(i);
        View AQ = view == null ? AQ(itemViewType) : view;
        if (itemViewType == 1) {
            if (AQ.getTag() != null && (AQ.getTag() instanceof a)) {
                view2 = AQ;
                aVar = (a) AQ.getTag();
            } else {
                View AQ2 = AQ(itemViewType);
                view2 = AQ2;
                aVar = (a) AQ2.getTag();
            }
            this.iYi.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
            this.iYi.getLayoutMode().onModeChanged(view2.findViewById(R.id.sign_all_forum_tip));
            aVar.iYn.setText(((com.baidu.tieba.signall.b) getItem(i)).getTitle());
            o(aVar.iYo, i);
            return view2;
        }
        if (AQ.getTag() == null || !(AQ.getTag() instanceof b)) {
            AQ = AQ(itemViewType);
        }
        a(AQ, viewGroup, i);
        return AQ;
    }

    private void o(TextView textView, int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        String format;
        int level = this.iXO == null ? 7 : this.iXO.getLevel();
        if (this.eUE == null || this.eUE.size() <= 0) {
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
        } else {
            Iterator<d> it = this.eUE.iterator();
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
            while (it.hasNext()) {
                d next = it.next();
                if (!TextUtils.isEmpty(next.getForumName())) {
                    if (next.cnn() >= level) {
                        if (next.aJZ()) {
                            i5++;
                        } else {
                            i4++;
                        }
                    } else if (next.aJZ()) {
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
            format = String.format(this.iYi.getPageContext().getString(R.string.signallforum_res), Integer.valueOf(i5), Integer.valueOf(i4));
        } else {
            format = String.format(this.iYi.getPageContext().getString(R.string.signallforum_res), Integer.valueOf(i3), Integer.valueOf(i2));
        }
        textView.setText(format);
    }

    private View bis() {
        View inflate = LayoutInflater.from(this.iYi.getPageContext().getPageActivity()).inflate(R.layout.sign_all_forum_nodata_item, (ViewGroup) null);
        NoDataView a2 = NoDataViewFactory.a(this.iYi.getPageContext().getPageActivity(), (LinearLayout) inflate.findViewById(R.id.sign_all_forum_no_data_view), NoDataViewFactory.c.a(NoDataViewFactory.ImgType.SINGALL, 0), NoDataViewFactory.d.ag(R.string.sign_all_forum_nodata_tip, R.string.sign_all_forum_nodata_guide), null);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.iYi.getLayoutMode().setNightMode(skinType == 1);
        this.iYi.getLayoutMode().onModeChanged(inflate);
        a2.onChangeSkinType(this.iYi.getPageContext(), skinType);
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
        public TextView iYA;
        public TextView iYB;
        public BarImageView iYp;
        public LinearLayout iYq;
        public TextView iYr;
        public ImageView iYs;
        public TextView iYt;
        public FrameLayout iYu;
        public TextView iYv;
        public RelativeLayout iYw;
        public ImageView iYx;
        public ProgressBar iYy;
        public TextView iYz;

        b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class a {
        public TextView iYn;
        public TextView iYo;

        a() {
        }
    }

    @Override // com.baidu.tieba.signall.SignSingleModel.a
    public void b(SignData signData) {
        String str = signData.forumId;
        synchronized (this) {
            this.iYj.remove(str);
        }
        a(str, true, signData, null);
    }

    @Override // com.baidu.tieba.signall.SignSingleModel.a
    public void ef(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            l.showToast(this.iYi.getPageContext().getPageActivity(), str2);
        }
        synchronized (this) {
            this.iYj.remove(str);
        }
        a(str, false, null, str2);
    }

    private void a(String str, boolean z, SignData signData, String str2) {
        int size = this.eUE.size();
        for (int i = 0; i < size; i++) {
            d dVar = this.eUE.get(i);
            if ((dVar.getForumId() + "").equals(str)) {
                dVar.qP(z);
                dVar.qQ(!z);
                dVar.qR(false);
                if (z) {
                    dVar.AN(signData.count_sign_num);
                    dVar.AP(signData.sign_bonus_point);
                    dVar.AM(1);
                    TbadkApplication.getInst().addSignedForum(dVar.getForumName(), signData.sign_bonus_point, -1);
                    ArrayList<d> cnd = this.iXO.cnd();
                    if (cnd.contains(dVar)) {
                        cnd.remove(dVar);
                        this.iXO.cnc().add(dVar);
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

    public void cnz() {
        this.isDestory = true;
        synchronized (this) {
            try {
                for (Map.Entry<String, SignSingleModel> entry : this.iYj.entrySet()) {
                    entry.getValue().cnS();
                }
                this.iYj.clear();
            }
        }
    }
}
