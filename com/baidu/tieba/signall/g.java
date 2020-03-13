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
/* loaded from: classes11.dex */
public class g extends BaseAdapter implements AbsListView.OnScrollListener, SignSingleModel.a {
    private boolean isDestory;
    private c jYA;
    private SignAllForumActivity jYU;
    private ArrayList<d> fSG = new ArrayList<>();
    private HashMap<String, SignSingleModel> jYV = new HashMap<>();
    private boolean gee = true;

    public g(SignAllForumActivity signAllForumActivity, TextView textView) {
        this.jYU = signAllForumActivity;
    }

    public void c(c cVar) {
        if (cVar != null) {
            this.jYA = cVar;
            this.fSG = cVar.cIy();
            if (this.fSG.size() == 0) {
                this.gee = false;
            } else {
                this.gee = true;
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
        if (this.gee) {
            return this.fSG.size();
        }
        return 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.fSG.size() > i) {
            return this.fSG.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    private View Ci(int i) {
        if (i == 0) {
            View inflate = LayoutInflater.from(this.jYU.getPageContext().getPageActivity()).inflate(R.layout.signallforum_item, (ViewGroup) null);
            b bVar = new b();
            bVar.jZb = (BarImageView) inflate.findViewById(R.id.signallforum_item_avatar);
            bVar.jZb.setIsRound(false);
            bVar.jZb.setGifIconSupport(false);
            bVar.jZd = (TextView) inflate.findViewById(R.id.signallforum_item_name);
            bVar.jZe = (ImageView) inflate.findViewById(R.id.signallforum_item_level);
            bVar.jZf = (TextView) inflate.findViewById(R.id.signallforum_item_exp);
            bVar.jZg = (FrameLayout) inflate.findViewById(R.id.signallforum_item_res_container);
            bVar.jZh = (TextView) inflate.findViewById(R.id.signallforum_item_days);
            bVar.jZi = (RelativeLayout) inflate.findViewById(R.id.signallforum_item_resign_container);
            bVar.jZj = (ImageView) inflate.findViewById(R.id.signallforum_item_resign_icon);
            bVar.jZk = (ProgressBar) inflate.findViewById(R.id.signallforum_item_resign_progress);
            bVar.jZl = (TextView) inflate.findViewById(R.id.signallforum_item_resign_text);
            bVar.jZm = (TextView) inflate.findViewById(R.id.signallforum_item_error);
            bVar.jZc = (LinearLayout) inflate.findViewById(R.id.signallforum_item_level_container);
            bVar.jZn = (TextView) inflate.findViewById(R.id.signallforum_item_increaseexp);
            inflate.setTag(bVar);
            return inflate;
        }
        View inflate2 = LayoutInflater.from(this.jYU.getPageContext().getPageActivity()).inflate(R.layout.signallforum_header, (ViewGroup) null);
        a aVar = new a();
        aVar.jYZ = (TextView) inflate2.findViewById(R.id.signallforum_head_title);
        aVar.jZa = (TextView) inflate2.findViewById(R.id.signallforum_head_res);
        inflate2.setTag(aVar);
        return inflate2;
    }

    private void a(View view, View view2, int i) {
        String str;
        this.jYU.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.jYU.getLayoutMode().onModeChanged(view);
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
            bVar.jZd.setText(str);
            am.setImageResource(bVar.jZe, BitmapHelper.getSmallGradeResourceIdNew(dVar.cIL()));
            bVar.jZf.setText(dVar.cIM() + "/" + dVar.cIN());
            bVar.jZn.clearAnimation();
            if (dVar.bdh()) {
                bVar.jZc.setVisibility(0);
                bVar.jZm.setVisibility(8);
                bVar.jZh.setVisibility(0);
                bVar.jZi.setVisibility(8);
                bVar.jZh.setText(String.format(this.jYU.getPageContext().getString(R.string.signallforum_days), Integer.valueOf(dVar.cIK())));
                if (dVar.cIR()) {
                    bVar.jZf.setText(this.jYU.getPageContext().getString(R.string.signallforum_uplevel));
                    bVar.jZn.setVisibility(8);
                } else {
                    bVar.jZf.setText(dVar.cIM() + "/" + dVar.cIN());
                    bVar.jZn.setVisibility(0);
                }
                int cIQ = dVar.cIQ();
                if (cIQ > 0) {
                    bVar.jZn.setVisibility(0);
                    bVar.jZn.setText("+" + cIQ);
                } else {
                    bVar.jZn.setVisibility(8);
                }
            } else if (dVar.cIO()) {
                bVar.jZc.setVisibility(0);
                bVar.jZm.setVisibility(8);
                bVar.jZn.setVisibility(8);
                bVar.jZh.setVisibility(8);
                bVar.jZi.setVisibility(0);
                if (dVar.cIP()) {
                    bVar.jZj.setVisibility(4);
                    bVar.jZk.setVisibility(0);
                    bVar.jZl.setText(R.string.signallforum_resigning);
                } else {
                    bVar.jZj.setVisibility(0);
                    bVar.jZk.setVisibility(4);
                    bVar.jZl.setText(R.string.signallforum_resign);
                }
                bVar.jZi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.signall.g.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view3) {
                        if (!dVar.cIP()) {
                            bVar.jZj.setVisibility(4);
                            bVar.jZk.setVisibility(0);
                            bVar.jZl.setText(R.string.signallforum_resigning);
                            dVar.sB(true);
                            SignSingleModel signSingleModel = new SignSingleModel(g.this.jYU);
                            signSingleModel.a(g.this);
                            String str2 = dVar.getForumId() + "";
                            synchronized (g.this) {
                                g.this.jYV.put(str2, signSingleModel);
                            }
                            signSingleModel.ex(dVar.getForumName(), str2);
                            TiebaStatic.log("signall_resign_click");
                        }
                    }
                });
            } else {
                bVar.jZh.setVisibility(8);
                bVar.jZi.setVisibility(8);
                bVar.jZn.setVisibility(8);
                bVar.jZc.setVisibility(0);
                bVar.jZm.setVisibility(8);
            }
            String avatar = dVar.getAvatar();
            bVar.jZb.setTag(avatar);
            bVar.jZb.setPlaceHolder(1);
            bVar.jZb.startLoad(avatar, 10, false);
        }
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        a aVar;
        if (!this.gee) {
            return bAV();
        }
        int itemViewType = getItemViewType(i);
        View Ci = view == null ? Ci(itemViewType) : view;
        if (itemViewType == 1) {
            if (Ci.getTag() != null && (Ci.getTag() instanceof a)) {
                view2 = Ci;
                aVar = (a) Ci.getTag();
            } else {
                View Ci2 = Ci(itemViewType);
                view2 = Ci2;
                aVar = (a) Ci2.getTag();
            }
            this.jYU.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
            this.jYU.getLayoutMode().onModeChanged(view2.findViewById(R.id.sign_all_forum_tip));
            aVar.jYZ.setText(((com.baidu.tieba.signall.b) getItem(i)).getTitle());
            h(aVar.jZa, i);
            return view2;
        }
        if (Ci.getTag() == null || !(Ci.getTag() instanceof b)) {
            Ci = Ci(itemViewType);
        }
        a(Ci, viewGroup, i);
        return Ci;
    }

    private void h(TextView textView, int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        String format;
        int level = this.jYA == null ? 7 : this.jYA.getLevel();
        if (this.fSG == null || this.fSG.size() <= 0) {
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
        } else {
            Iterator<d> it = this.fSG.iterator();
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
            while (it.hasNext()) {
                d next = it.next();
                if (!TextUtils.isEmpty(next.getForumName())) {
                    if (next.cIL() >= level) {
                        if (next.bdh()) {
                            i5++;
                        } else {
                            i4++;
                        }
                    } else if (next.bdh()) {
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
            format = String.format(this.jYU.getPageContext().getString(R.string.signallforum_res), Integer.valueOf(i5), Integer.valueOf(i4));
        } else {
            format = String.format(this.jYU.getPageContext().getString(R.string.signallforum_res), Integer.valueOf(i3), Integer.valueOf(i2));
        }
        textView.setText(format);
    }

    private View bAV() {
        View inflate = LayoutInflater.from(this.jYU.getPageContext().getPageActivity()).inflate(R.layout.sign_all_forum_nodata_item, (ViewGroup) null);
        NoDataView a2 = NoDataViewFactory.a(this.jYU.getPageContext().getPageActivity(), (LinearLayout) inflate.findViewById(R.id.sign_all_forum_no_data_view), NoDataViewFactory.c.a(NoDataViewFactory.ImgType.FINDBAR, this.jYU.getResources().getDimensionPixelSize(R.dimen.tbds90)), NoDataViewFactory.d.cA(null, this.jYU.getResources().getString(R.string.no_bar_attentioned)), null);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.jYU.getLayoutMode().setNightMode(skinType == 1);
        this.jYU.getLayoutMode().onModeChanged(inflate);
        a2.onChangeSkinType(this.jYU.getPageContext(), skinType);
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
    /* loaded from: classes11.dex */
    public class b {
        public BarImageView jZb;
        public LinearLayout jZc;
        public TextView jZd;
        public ImageView jZe;
        public TextView jZf;
        public FrameLayout jZg;
        public TextView jZh;
        public RelativeLayout jZi;
        public ImageView jZj;
        public ProgressBar jZk;
        public TextView jZl;
        public TextView jZm;
        public TextView jZn;

        b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public class a {
        public TextView jYZ;
        public TextView jZa;

        a() {
        }
    }

    @Override // com.baidu.tieba.signall.SignSingleModel.a
    public void c(SignData signData) {
        String str = signData.forumId;
        synchronized (this) {
            this.jYV.remove(str);
        }
        a(str, true, signData, null);
    }

    @Override // com.baidu.tieba.signall.SignSingleModel.a
    public void ew(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            l.showToast(this.jYU.getPageContext().getPageActivity(), str2);
        }
        synchronized (this) {
            this.jYV.remove(str);
        }
        a(str, false, null, str2);
    }

    private void a(String str, boolean z, SignData signData, String str2) {
        int size = this.fSG.size();
        for (int i = 0; i < size; i++) {
            d dVar = this.fSG.get(i);
            if ((dVar.getForumId() + "").equals(str)) {
                dVar.sz(z);
                dVar.sA(!z);
                dVar.sB(false);
                if (z) {
                    dVar.Cf(signData.count_sign_num);
                    dVar.Ch(signData.sign_bonus_point);
                    dVar.Ce(1);
                    TbadkApplication.getInst().addSignedForum(dVar.getForumName(), signData.sign_bonus_point, -1);
                    ArrayList<d> cIB = this.jYA.cIB();
                    if (cIB.contains(dVar)) {
                        cIB.remove(dVar);
                        this.jYA.cIA().add(dVar);
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

    public void cIX() {
        this.isDestory = true;
        synchronized (this) {
            try {
                for (Map.Entry<String, SignSingleModel> entry : this.jYV.entrySet()) {
                    entry.getValue().cJq();
                }
                this.jYV.clear();
            }
        }
    }
}
