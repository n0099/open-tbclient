package com.baidu.tieba.setting.privacy;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class PrivacyPermissionActivity extends BaseActivity<PrivacyPermissionActivity> {
    private View bWc;
    private NavigationBar mNavigationBar;
    private RecyclerView mRecyclerView;
    private View mRootView;
    private List<a> mDataList = new ArrayList();
    private String[] iuq = {"android.permission.CAMERA", "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.RECORD_AUDIO", "android.permission.ACCESS_FINE_LOCATION"};
    private String[] iur = {getString(d.j.allow_to_use_camera), getString(d.j.allow_to_use_sdcard), getString(d.j.allow_to_use_record), getString(d.j.allow_to_use_location)};
    private String[] ius = {getString(d.j.privacy_camera_info), getString(d.j.privacy_sdcard_info), getString(d.j.privacy_record_info), getString(d.j.privacy_location_info)};
    private RecyclerView.Adapter mAdapter = new RecyclerView.Adapter() { // from class: com.baidu.tieba.setting.privacy.PrivacyPermissionActivity.1
        @Override // android.support.v7.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            if (i == 0) {
                return new c(LayoutInflater.from(PrivacyPermissionActivity.this.getActivity()).inflate(d.h.layout_privacy_permisson_item, viewGroup, false));
            }
            if (i != 1) {
                return null;
            }
            return new b(LayoutInflater.from(PrivacyPermissionActivity.this.getActivity()).inflate(d.h.textview_permission_detail, viewGroup, false));
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            int itemViewType = getItemViewType(i);
            if (itemViewType == 0) {
                ((c) viewHolder).a((a) PrivacyPermissionActivity.this.mDataList.get(i));
                ((c) viewHolder).onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            } else if (itemViewType == 1) {
                ((b) viewHolder).onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            a aVar = (a) PrivacyPermissionActivity.this.mDataList.get(i);
            if (aVar == null) {
                return 0;
            }
            return aVar.fRa;
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public int getItemCount() {
            return PrivacyPermissionActivity.this.mDataList.size();
        }
    };

    /* loaded from: classes3.dex */
    public static class a {
        public int fRa = 0;
        public String info;
        public boolean isOpen;
        public String name;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(d.h.privacy_permission_activity);
        this.mRootView = findViewById(d.g.root_view);
        this.mNavigationBar = (NavigationBar) findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.bWc = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(getPageContext().getString(d.j.privacy_permission));
        this.mRecyclerView = (RecyclerView) findViewById(d.g.recycler_view);
        this.mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        this.mRecyclerView.setAdapter(this.mAdapter);
        for (int i = 0; i < this.iuq.length; i++) {
            a aVar = new a();
            aVar.fRa = 0;
            aVar.name = this.iur[i];
            aVar.info = this.ius[i];
            this.mDataList.add(aVar);
        }
        a aVar2 = new a();
        aVar2.fRa = 1;
        this.mDataList.add(aVar2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.mDataList.size() >= this.iuq.length) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.iuq.length) {
                    this.mDataList.get(i2).isOpen = ab.au(getActivity(), this.iuq[i2]);
                    i = i2 + 1;
                } else {
                    this.mAdapter.notifyDataSetChanged();
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        al.l(this.mRootView, d.C0277d.common_color_10238);
    }

    /* loaded from: classes3.dex */
    public static class c extends RecyclerView.ViewHolder {
        private TbSettingTextTipView iuw;
        private TextView iux;
        private View.OnClickListener mOnClickListener;
        private int mSkinType;

        public c(View view) {
            super(view);
            this.mSkinType = 3;
            this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.setting.privacy.PrivacyPermissionActivity.c.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (c.this.itemView != null) {
                        Intent intent = new Intent();
                        intent.addFlags(268435456);
                        intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
                        intent.setData(Uri.fromParts("package", c.this.itemView.getContext().getPackageName(), null));
                        c.this.itemView.getContext().startActivity(intent);
                    }
                }
            };
            this.iuw = (TbSettingTextTipView) view.findViewById(d.g.privacy_name);
            this.iuw.setOnClickListener(this.mOnClickListener);
            this.iux = (TextView) view.findViewById(d.g.privacy_info);
        }

        public void a(a aVar) {
            String string;
            if (aVar != null && this.itemView != null) {
                this.iuw.setText(aVar.name);
                TbSettingTextTipView tbSettingTextTipView = this.iuw;
                if (aVar.isOpen) {
                    string = this.itemView.getContext().getString(d.j.privacy_permisson_open);
                } else {
                    string = this.itemView.getContext().getString(d.j.privacy_permisson_closed);
                }
                tbSettingTextTipView.setTip(string);
                this.iux.setText(aVar.info);
            }
        }

        public void onChangeSkinType(int i) {
            if (i != this.mSkinType) {
                this.iuw.onChangeSkinType(i);
                al.k(this.iuw, d.f.more_all);
                al.l(this.iux, d.C0277d.common_color_10238);
                al.j(this.iux, d.C0277d.cp_cont_c);
                this.mSkinType = i;
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class b extends RecyclerView.ViewHolder {
        private TextView iuu;
        private View.OnClickListener mOnClickListener;
        private int mSkinType;

        public b(View view) {
            super(view);
            this.mSkinType = 3;
            this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.setting.privacy.PrivacyPermissionActivity.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    com.baidu.tbadk.browser.a.ar(b.this.itemView.getContext(), TbConfig.PRIVACY_DETAIL_URL);
                }
            };
            this.iuu = (TextView) view;
            this.iuu.setOnClickListener(this.mOnClickListener);
        }

        public void onChangeSkinType(int i) {
            if (i != this.mSkinType) {
                al.j(this.iuu, d.C0277d.cp_link_tip_a);
                al.k(this.itemView, d.f.more_all);
                this.mSkinType = i;
            }
        }
    }
}
