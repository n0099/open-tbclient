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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.R;
import com.baidu.webkit.sdk.PermissionRequest;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes13.dex */
public class PrivacyPermissionActivity extends BaseActivity<PrivacyPermissionActivity> {
    private View mBack;
    private NavigationBar mNavigationBar;
    private RecyclerView mRecyclerView;
    private View mRootView;
    private List<a> mDataList = new ArrayList();
    private String[] kYd = {PermissionRequest.RESOURCE_VIDEO_CAPTURE, "android.permission.WRITE_EXTERNAL_STORAGE", PermissionRequest.RESOURCE_AUDIO_CAPTURE, "android.permission.ACCESS_FINE_LOCATION"};
    private String[] kYe = {getString(R.string.allow_to_use_camera), getString(R.string.allow_to_use_sdcard), getString(R.string.allow_to_use_record), getString(R.string.allow_to_use_location)};
    private String[] kYf = {getString(R.string.privacy_camera_info), getString(R.string.privacy_sdcard_info), getString(R.string.privacy_record_info), getString(R.string.privacy_location_info)};
    private RecyclerView.Adapter mAdapter = new RecyclerView.Adapter() { // from class: com.baidu.tieba.setting.privacy.PrivacyPermissionActivity.1
        @Override // android.support.v7.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            if (i == 0) {
                return new c(LayoutInflater.from(PrivacyPermissionActivity.this.getActivity()).inflate(R.layout.layout_privacy_permisson_item, viewGroup, false));
            }
            if (i != 1) {
                return null;
            }
            return new b(LayoutInflater.from(PrivacyPermissionActivity.this.getActivity()).inflate(R.layout.textview_permission_detail, viewGroup, false));
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
            return aVar.baa;
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public int getItemCount() {
            return PrivacyPermissionActivity.this.mDataList.size();
        }
    };

    /* loaded from: classes13.dex */
    public static class a {
        public int baa = 0;
        public String info;
        public boolean isOpen;
        public String name;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.privacy_permission_activity);
        this.mRootView = findViewById(R.id.root_view);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(getPageContext().getString(R.string.privacy_permission));
        this.mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        this.mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        this.mRecyclerView.setAdapter(this.mAdapter);
        for (int i = 0; i < this.kYd.length; i++) {
            a aVar = new a();
            aVar.baa = 0;
            aVar.name = this.kYe[i];
            aVar.info = this.kYf[i];
            this.mDataList.add(aVar);
        }
        a aVar2 = new a();
        aVar2.baa = 1;
        this.mDataList.add(aVar2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.mDataList.size() >= this.kYd.length) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.kYd.length) {
                    this.mDataList.get(i2).isOpen = ab.ah(getActivity(), this.kYd[i2]);
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
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_c);
        this.mAdapter.notifyDataSetChanged();
    }

    /* loaded from: classes13.dex */
    public static class c extends RecyclerView.ViewHolder {
        private TbSettingTextTipView kYj;
        private TextView kYk;
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
            this.kYj = (TbSettingTextTipView) view.findViewById(R.id.privacy_name);
            this.kYj.setOnClickListener(this.mOnClickListener);
            this.kYk = (TextView) view.findViewById(R.id.privacy_info);
        }

        public void a(a aVar) {
            String string;
            if (aVar != null && this.itemView != null) {
                this.kYj.setText(aVar.name);
                TbSettingTextTipView tbSettingTextTipView = this.kYj;
                if (aVar.isOpen) {
                    string = this.itemView.getContext().getString(R.string.privacy_permisson_open);
                } else {
                    string = this.itemView.getContext().getString(R.string.privacy_permisson_closed);
                }
                tbSettingTextTipView.setTip(string);
                this.kYk.setText(aVar.info);
            }
        }

        public void onChangeSkinType(int i) {
            if (i != this.mSkinType) {
                this.kYj.onChangeSkinType(i);
                am.setBackgroundResource(this.kYj, R.drawable.more_all);
                am.setBackgroundColor(this.kYk, R.color.cp_bg_line_c);
                am.setViewTextColor(this.kYk, (int) R.color.cp_cont_c);
                this.mSkinType = i;
            }
        }
    }

    /* loaded from: classes13.dex */
    public static class b extends RecyclerView.ViewHolder {
        private TextView kYh;
        private View.OnClickListener mOnClickListener;
        private int mSkinType;

        public b(View view) {
            super(view);
            this.mSkinType = 3;
            this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.setting.privacy.PrivacyPermissionActivity.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    com.baidu.tbadk.browser.a.startWebActivity(b.this.itemView.getContext(), TbConfig.PRIVACY_DETAIL_URL);
                }
            };
            this.kYh = (TextView) view;
            this.kYh.setOnClickListener(this.mOnClickListener);
        }

        public void onChangeSkinType(int i) {
            if (i != this.mSkinType) {
                am.setViewTextColor(this.kYh, (int) R.color.cp_link_tip_a);
                am.setBackgroundResource(this.itemView, R.drawable.more_all);
                this.mSkinType = i;
            }
        }
    }
}
