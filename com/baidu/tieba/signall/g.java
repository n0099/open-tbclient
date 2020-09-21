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
    private c mfD;
    private boolean mfQ;
    private SignAllForumActivity mgb;
    private ArrayList<d> hzD = new ArrayList<>();
    private HashMap<String, SignSingleModel> mgc = new HashMap<>();
    private boolean hPr = true;

    public g(SignAllForumActivity signAllForumActivity, TextView textView) {
        this.mgb = signAllForumActivity;
    }

    public void c(c cVar) {
        if (cVar != null) {
            this.mfD = cVar;
            this.hzD = cVar.dxG();
            if (this.hzD.size() == 0) {
                this.hPr = false;
            } else {
                this.hPr = true;
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
        if (this.hPr) {
            return this.hzD.size();
        }
        return 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.hzD.size() > i) {
            return this.hzD.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    private View Ia(int i) {
        if (i == 0) {
            View inflate = LayoutInflater.from(this.mgb.getPageContext().getPageActivity()).inflate(R.layout.signallforum_item, (ViewGroup) null);
            b bVar = new b();
            bVar.mgi = (BarImageView) inflate.findViewById(R.id.signallforum_item_avatar);
            bVar.mgi.setIsRound(false);
            bVar.mgi.setGifIconSupport(false);
            bVar.mgk = (TextView) inflate.findViewById(R.id.signallforum_item_name);
            bVar.fsJ = (ImageView) inflate.findViewById(R.id.signallforum_item_level);
            bVar.mgl = (TextView) inflate.findViewById(R.id.signallforum_item_exp);
            bVar.mgm = (FrameLayout) inflate.findViewById(R.id.signallforum_item_res_container);
            bVar.mgn = (TextView) inflate.findViewById(R.id.signallforum_item_days);
            bVar.mgo = (RelativeLayout) inflate.findViewById(R.id.signallforum_item_resign_container);
            bVar.mgp = (ImageView) inflate.findViewById(R.id.signallforum_item_resign_icon);
            bVar.mgq = (ProgressBar) inflate.findViewById(R.id.signallforum_item_resign_progress);
            bVar.mgr = (TextView) inflate.findViewById(R.id.signallforum_item_resign_text);
            bVar.mgs = (TextView) inflate.findViewById(R.id.signallforum_item_error);
            bVar.mgj = (LinearLayout) inflate.findViewById(R.id.signallforum_item_level_container);
            bVar.mgt = (TextView) inflate.findViewById(R.id.signallforum_item_increaseexp);
            inflate.setTag(bVar);
            return inflate;
        }
        View inflate2 = LayoutInflater.from(this.mgb.getPageContext().getPageActivity()).inflate(R.layout.signallforum_header, (ViewGroup) null);
        a aVar = new a();
        aVar.mgg = (TextView) inflate2.findViewById(R.id.signallforum_head_title);
        aVar.mgh = (TextView) inflate2.findViewById(R.id.signallforum_head_res);
        inflate2.setTag(aVar);
        return inflate2;
    }

    private void a(View view, View view2, int i) {
        String str;
        this.mgb.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.mgb.getLayoutMode().onModeChanged(view);
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
            bVar.mgk.setText(str);
            ap.setImageResource(bVar.fsJ, BitmapHelper.getSmallGradeResourceIdNew(dVar.dxT()));
            bVar.mgl.setText(dVar.dxU() + "/" + dVar.dxV());
            bVar.mgt.clearAnimation();
            if (dVar.bHX()) {
                bVar.mgj.setVisibility(0);
                bVar.mgs.setVisibility(8);
                bVar.mgn.setVisibility(0);
                bVar.mgo.setVisibility(8);
                bVar.mgn.setText(String.format(this.mgb.getPageContext().getString(R.string.signallforum_days), Integer.valueOf(dVar.dxS())));
                if (dVar.dxZ()) {
                    bVar.mgl.setText(this.mgb.getPageContext().getString(R.string.signallforum_uplevel));
                    bVar.mgt.setVisibility(8);
                } else {
                    bVar.mgl.setText(dVar.dxU() + "/" + dVar.dxV());
                    bVar.mgt.setVisibility(0);
                }
                int dxY = dVar.dxY();
                if (dxY > 0) {
                    bVar.mgt.setVisibility(0);
                    bVar.mgt.setText("+" + dxY);
                } else {
                    bVar.mgt.setVisibility(8);
                }
            } else if (dVar.dxW()) {
                bVar.mgj.setVisibility(0);
                bVar.mgs.setVisibility(8);
                bVar.mgt.setVisibility(8);
                bVar.mgn.setVisibility(8);
                bVar.mgo.setVisibility(0);
                if (dVar.dxX()) {
                    bVar.mgp.setVisibility(4);
                    bVar.mgq.setVisibility(0);
                    bVar.mgr.setText(R.string.signallforum_resigning);
                } else {
                    bVar.mgp.setVisibility(0);
                    bVar.mgq.setVisibility(4);
                    bVar.mgr.setText(R.string.signallforum_resign);
                }
                bVar.mgo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.signall.g.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view3) {
                        if (!dVar.dxX()) {
                            bVar.mgp.setVisibility(4);
                            bVar.mgq.setVisibility(0);
                            bVar.mgr.setText(R.string.signallforum_resigning);
                            dVar.vY(true);
                            SignSingleModel signSingleModel = new SignSingleModel(g.this.mgb);
                            signSingleModel.a(g.this);
                            String str2 = dVar.getForumId() + "";
                            synchronized (g.this) {
                                g.this.mgc.put(str2, signSingleModel);
                            }
                            signSingleModel.fY(dVar.getForumName(), str2);
                            TiebaStatic.log("signall_resign_click");
                        }
                    }
                });
            } else {
                bVar.mgn.setVisibility(8);
                bVar.mgo.setVisibility(8);
                bVar.mgt.setVisibility(8);
                bVar.mgj.setVisibility(0);
                bVar.mgs.setVisibility(8);
            }
            String avatar = dVar.getAvatar();
            bVar.mgi.setTag(avatar);
            bVar.mgi.setPlaceHolder(1);
            bVar.mgi.startLoad(avatar, 10, false);
        }
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        a aVar;
        if (!this.hPr) {
            return clX();
        }
        int itemViewType = getItemViewType(i);
        View Ia = view == null ? Ia(itemViewType) : view;
        if (itemViewType == 1) {
            if (Ia.getTag() != null && (Ia.getTag() instanceof a)) {
                view2 = Ia;
                aVar = (a) Ia.getTag();
            } else {
                View Ia2 = Ia(itemViewType);
                view2 = Ia2;
                aVar = (a) Ia2.getTag();
            }
            this.mgb.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
            this.mgb.getLayoutMode().onModeChanged(view2.findViewById(R.id.sign_all_forum_tip));
            aVar.mgg.setText(((com.baidu.tieba.signall.b) getItem(i)).getTitle());
            j(aVar.mgh, i);
            return view2;
        }
        if (Ia.getTag() == null || !(Ia.getTag() instanceof b)) {
            Ia = Ia(itemViewType);
        }
        a(Ia, viewGroup, i);
        return Ia;
    }

    private void j(TextView textView, int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        String format;
        int level = this.mfD == null ? 7 : this.mfD.getLevel();
        if (this.hzD == null || this.hzD.size() <= 0) {
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
        } else {
            Iterator<d> it = this.hzD.iterator();
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
            while (it.hasNext()) {
                d next = it.next();
                if (!TextUtils.isEmpty(next.getForumName())) {
                    if (next.dxT() >= level) {
                        if (next.bHX()) {
                            i5++;
                        } else {
                            i4++;
                        }
                    } else if (next.bHX()) {
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
            format = String.format(this.mgb.getPageContext().getString(R.string.signallforum_res), Integer.valueOf(i5), Integer.valueOf(i4));
        } else {
            format = String.format(this.mgb.getPageContext().getString(R.string.signallforum_res), Integer.valueOf(i3), Integer.valueOf(i2));
        }
        textView.setText(format);
    }

    private View clX() {
        View inflate = LayoutInflater.from(this.mgb.getPageContext().getPageActivity()).inflate(R.layout.sign_all_forum_nodata_item, (ViewGroup) null);
        NoDataView a2 = NoDataViewFactory.a(this.mgb.getPageContext().getPageActivity(), (LinearLayout) inflate.findViewById(R.id.sign_all_forum_no_data_view), NoDataViewFactory.c.a(NoDataViewFactory.ImgType.FINDBAR, this.mgb.getResources().getDimensionPixelSize(R.dimen.tbds90)), NoDataViewFactory.d.dG(null, this.mgb.getResources().getString(R.string.no_bar_attentioned)), null);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.mgb.getLayoutMode().setNightMode(skinType == 1);
        this.mgb.getLayoutMode().onModeChanged(inflate);
        a2.onChangeSkinType(this.mgb.getPageContext(), skinType);
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
        public ImageView fsJ;
        public BarImageView mgi;
        public LinearLayout mgj;
        public TextView mgk;
        public TextView mgl;
        public FrameLayout mgm;
        public TextView mgn;
        public RelativeLayout mgo;
        public ImageView mgp;
        public ProgressBar mgq;
        public TextView mgr;
        public TextView mgs;
        public TextView mgt;

        b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes23.dex */
    public class a {
        public TextView mgg;
        public TextView mgh;

        a() {
        }
    }

    @Override // com.baidu.tieba.signall.SignSingleModel.a
    public void c(SignData signData) {
        String str = signData.forumId;
        synchronized (this) {
            this.mgc.remove(str);
        }
        a(str, true, signData, null);
    }

    @Override // com.baidu.tieba.signall.SignSingleModel.a
    public void fX(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            l.showToast(this.mgb.getPageContext().getPageActivity(), str2);
        }
        synchronized (this) {
            this.mgc.remove(str);
        }
        a(str, false, null, str2);
    }

    private void a(String str, boolean z, SignData signData, String str2) {
        int size = this.hzD.size();
        for (int i = 0; i < size; i++) {
            d dVar = this.hzD.get(i);
            if ((dVar.getForumId() + "").equals(str)) {
                dVar.vW(z);
                dVar.vX(!z);
                dVar.vY(false);
                if (z) {
                    dVar.HX(signData.count_sign_num);
                    dVar.HZ(signData.sign_bonus_point);
                    dVar.HW(1);
                    TbadkApplication.getInst().addSignedForum(dVar.getForumName(), signData.sign_bonus_point, -1);
                    ArrayList<d> dxJ = this.mfD.dxJ();
                    if (dxJ.contains(dVar)) {
                        dxJ.remove(dVar);
                        this.mfD.dxI().add(dVar);
                    }
                } else {
                    dVar.setErrorMsg(str2);
                }
                if (!this.mfQ) {
                    notifyDataSetChanged();
                    return;
                }
                return;
            }
        }
    }

    public void dyf() {
        this.mfQ = true;
        synchronized (this) {
            try {
                for (Map.Entry<String, SignSingleModel> entry : this.mgc.entrySet()) {
                    entry.getValue().dyy();
                }
                this.mgc.clear();
            }
        }
    }
}
