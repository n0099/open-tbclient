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
    private SignAllForumActivity kJQ;
    private c kJt;
    private ArrayList<d> gyd = new ArrayList<>();
    private HashMap<String, SignSingleModel> kJR = new HashMap<>();
    private boolean gOb = true;

    public g(SignAllForumActivity signAllForumActivity, TextView textView) {
        this.kJQ = signAllForumActivity;
    }

    public void c(c cVar) {
        if (cVar != null) {
            this.kJt = cVar;
            this.gyd = cVar.cTs();
            if (this.gyd.size() == 0) {
                this.gOb = false;
            } else {
                this.gOb = true;
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
        if (this.gOb) {
            return this.gyd.size();
        }
        return 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.gyd.size() > i) {
            return this.gyd.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    private View CQ(int i) {
        if (i == 0) {
            View inflate = LayoutInflater.from(this.kJQ.getPageContext().getPageActivity()).inflate(R.layout.signallforum_item, (ViewGroup) null);
            b bVar = new b();
            bVar.kJX = (BarImageView) inflate.findViewById(R.id.signallforum_item_avatar);
            bVar.kJX.setIsRound(false);
            bVar.kJX.setGifIconSupport(false);
            bVar.kJZ = (TextView) inflate.findViewById(R.id.signallforum_item_name);
            bVar.kKa = (ImageView) inflate.findViewById(R.id.signallforum_item_level);
            bVar.kKb = (TextView) inflate.findViewById(R.id.signallforum_item_exp);
            bVar.kKc = (FrameLayout) inflate.findViewById(R.id.signallforum_item_res_container);
            bVar.kKd = (TextView) inflate.findViewById(R.id.signallforum_item_days);
            bVar.kKe = (RelativeLayout) inflate.findViewById(R.id.signallforum_item_resign_container);
            bVar.kKf = (ImageView) inflate.findViewById(R.id.signallforum_item_resign_icon);
            bVar.kKg = (ProgressBar) inflate.findViewById(R.id.signallforum_item_resign_progress);
            bVar.kKh = (TextView) inflate.findViewById(R.id.signallforum_item_resign_text);
            bVar.kKi = (TextView) inflate.findViewById(R.id.signallforum_item_error);
            bVar.kJY = (LinearLayout) inflate.findViewById(R.id.signallforum_item_level_container);
            bVar.kKj = (TextView) inflate.findViewById(R.id.signallforum_item_increaseexp);
            inflate.setTag(bVar);
            return inflate;
        }
        View inflate2 = LayoutInflater.from(this.kJQ.getPageContext().getPageActivity()).inflate(R.layout.signallforum_header, (ViewGroup) null);
        a aVar = new a();
        aVar.kJV = (TextView) inflate2.findViewById(R.id.signallforum_head_title);
        aVar.kJW = (TextView) inflate2.findViewById(R.id.signallforum_head_res);
        inflate2.setTag(aVar);
        return inflate2;
    }

    private void a(View view, View view2, int i) {
        String str;
        this.kJQ.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.kJQ.getLayoutMode().onModeChanged(view);
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
            bVar.kJZ.setText(str);
            am.setImageResource(bVar.kKa, BitmapHelper.getSmallGradeResourceIdNew(dVar.cTF()));
            bVar.kKb.setText(dVar.cTG() + "/" + dVar.cTH());
            bVar.kKj.clearAnimation();
            if (dVar.bmb()) {
                bVar.kJY.setVisibility(0);
                bVar.kKi.setVisibility(8);
                bVar.kKd.setVisibility(0);
                bVar.kKe.setVisibility(8);
                bVar.kKd.setText(String.format(this.kJQ.getPageContext().getString(R.string.signallforum_days), Integer.valueOf(dVar.cTE())));
                if (dVar.cTL()) {
                    bVar.kKb.setText(this.kJQ.getPageContext().getString(R.string.signallforum_uplevel));
                    bVar.kKj.setVisibility(8);
                } else {
                    bVar.kKb.setText(dVar.cTG() + "/" + dVar.cTH());
                    bVar.kKj.setVisibility(0);
                }
                int cTK = dVar.cTK();
                if (cTK > 0) {
                    bVar.kKj.setVisibility(0);
                    bVar.kKj.setText("+" + cTK);
                } else {
                    bVar.kKj.setVisibility(8);
                }
            } else if (dVar.cTI()) {
                bVar.kJY.setVisibility(0);
                bVar.kKi.setVisibility(8);
                bVar.kKj.setVisibility(8);
                bVar.kKd.setVisibility(8);
                bVar.kKe.setVisibility(0);
                if (dVar.cTJ()) {
                    bVar.kKf.setVisibility(4);
                    bVar.kKg.setVisibility(0);
                    bVar.kKh.setText(R.string.signallforum_resigning);
                } else {
                    bVar.kKf.setVisibility(0);
                    bVar.kKg.setVisibility(4);
                    bVar.kKh.setText(R.string.signallforum_resign);
                }
                bVar.kKe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.signall.g.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view3) {
                        if (!dVar.cTJ()) {
                            bVar.kKf.setVisibility(4);
                            bVar.kKg.setVisibility(0);
                            bVar.kKh.setText(R.string.signallforum_resigning);
                            dVar.tI(true);
                            SignSingleModel signSingleModel = new SignSingleModel(g.this.kJQ);
                            signSingleModel.a(g.this);
                            String str2 = dVar.getForumId() + "";
                            synchronized (g.this) {
                                g.this.kJR.put(str2, signSingleModel);
                            }
                            signSingleModel.eK(dVar.getForumName(), str2);
                            TiebaStatic.log("signall_resign_click");
                        }
                    }
                });
            } else {
                bVar.kKd.setVisibility(8);
                bVar.kKe.setVisibility(8);
                bVar.kKj.setVisibility(8);
                bVar.kJY.setVisibility(0);
                bVar.kKi.setVisibility(8);
            }
            String avatar = dVar.getAvatar();
            bVar.kJX.setTag(avatar);
            bVar.kJX.setPlaceHolder(1);
            bVar.kJX.startLoad(avatar, 10, false);
        }
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        a aVar;
        if (!this.gOb) {
            return bLz();
        }
        int itemViewType = getItemViewType(i);
        View CQ = view == null ? CQ(itemViewType) : view;
        if (itemViewType == 1) {
            if (CQ.getTag() != null && (CQ.getTag() instanceof a)) {
                view2 = CQ;
                aVar = (a) CQ.getTag();
            } else {
                View CQ2 = CQ(itemViewType);
                view2 = CQ2;
                aVar = (a) CQ2.getTag();
            }
            this.kJQ.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
            this.kJQ.getLayoutMode().onModeChanged(view2.findViewById(R.id.sign_all_forum_tip));
            aVar.kJV.setText(((com.baidu.tieba.signall.b) getItem(i)).getTitle());
            h(aVar.kJW, i);
            return view2;
        }
        if (CQ.getTag() == null || !(CQ.getTag() instanceof b)) {
            CQ = CQ(itemViewType);
        }
        a(CQ, viewGroup, i);
        return CQ;
    }

    private void h(TextView textView, int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        String format;
        int level = this.kJt == null ? 7 : this.kJt.getLevel();
        if (this.gyd == null || this.gyd.size() <= 0) {
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
        } else {
            Iterator<d> it = this.gyd.iterator();
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
            while (it.hasNext()) {
                d next = it.next();
                if (!TextUtils.isEmpty(next.getForumName())) {
                    if (next.cTF() >= level) {
                        if (next.bmb()) {
                            i5++;
                        } else {
                            i4++;
                        }
                    } else if (next.bmb()) {
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
            format = String.format(this.kJQ.getPageContext().getString(R.string.signallforum_res), Integer.valueOf(i5), Integer.valueOf(i4));
        } else {
            format = String.format(this.kJQ.getPageContext().getString(R.string.signallforum_res), Integer.valueOf(i3), Integer.valueOf(i2));
        }
        textView.setText(format);
    }

    private View bLz() {
        View inflate = LayoutInflater.from(this.kJQ.getPageContext().getPageActivity()).inflate(R.layout.sign_all_forum_nodata_item, (ViewGroup) null);
        NoDataView a2 = NoDataViewFactory.a(this.kJQ.getPageContext().getPageActivity(), (LinearLayout) inflate.findViewById(R.id.sign_all_forum_no_data_view), NoDataViewFactory.c.a(NoDataViewFactory.ImgType.FINDBAR, this.kJQ.getResources().getDimensionPixelSize(R.dimen.tbds90)), NoDataViewFactory.d.cK(null, this.kJQ.getResources().getString(R.string.no_bar_attentioned)), null);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.kJQ.getLayoutMode().setNightMode(skinType == 1);
        this.kJQ.getLayoutMode().onModeChanged(inflate);
        a2.onChangeSkinType(this.kJQ.getPageContext(), skinType);
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
        public BarImageView kJX;
        public LinearLayout kJY;
        public TextView kJZ;
        public ImageView kKa;
        public TextView kKb;
        public FrameLayout kKc;
        public TextView kKd;
        public RelativeLayout kKe;
        public ImageView kKf;
        public ProgressBar kKg;
        public TextView kKh;
        public TextView kKi;
        public TextView kKj;

        b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public class a {
        public TextView kJV;
        public TextView kJW;

        a() {
        }
    }

    @Override // com.baidu.tieba.signall.SignSingleModel.a
    public void c(SignData signData) {
        String str = signData.forumId;
        synchronized (this) {
            this.kJR.remove(str);
        }
        a(str, true, signData, null);
    }

    @Override // com.baidu.tieba.signall.SignSingleModel.a
    public void eJ(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            l.showToast(this.kJQ.getPageContext().getPageActivity(), str2);
        }
        synchronized (this) {
            this.kJR.remove(str);
        }
        a(str, false, null, str2);
    }

    private void a(String str, boolean z, SignData signData, String str2) {
        int size = this.gyd.size();
        for (int i = 0; i < size; i++) {
            d dVar = this.gyd.get(i);
            if ((dVar.getForumId() + "").equals(str)) {
                dVar.tG(z);
                dVar.tH(!z);
                dVar.tI(false);
                if (z) {
                    dVar.CN(signData.count_sign_num);
                    dVar.CP(signData.sign_bonus_point);
                    dVar.CM(1);
                    TbadkApplication.getInst().addSignedForum(dVar.getForumName(), signData.sign_bonus_point, -1);
                    ArrayList<d> cTv = this.kJt.cTv();
                    if (cTv.contains(dVar)) {
                        cTv.remove(dVar);
                        this.kJt.cTu().add(dVar);
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

    public void cTS() {
        this.isDestory = true;
        synchronized (this) {
            try {
                for (Map.Entry<String, SignSingleModel> entry : this.kJR.entrySet()) {
                    entry.getValue().cUl();
                }
                this.kJR.clear();
            }
        }
    }
}
