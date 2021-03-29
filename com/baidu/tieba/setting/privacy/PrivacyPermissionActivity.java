package com.baidu.tieba.setting.privacy;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.R;
import com.baidu.webkit.sdk.PermissionRequest;
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class PrivacyPermissionActivity extends BaseActivity<PrivacyPermissionActivity> {
    public View mBack;
    public NavigationBar mNavigationBar;
    public RecyclerView mRecyclerView;
    public View mRootView;
    public List<b> mDataList = new ArrayList();
    public String[] PERMISSION_ARRAY = {PermissionRequest.RESOURCE_VIDEO_CAPTURE, StorageUtils.EXTERNAL_STORAGE_PERMISSION, PermissionRequest.RESOURCE_AUDIO_CAPTURE, "android.permission.ACCESS_FINE_LOCATION"};
    public String[] PERMISSION_NAME_ARRAY = {getString(R.string.allow_to_use_camera), getString(R.string.allow_to_use_sdcard), getString(R.string.allow_to_use_record), getString(R.string.allow_to_use_location)};
    public String[] PERMISSION_INFO_ARRAY = {getString(R.string.privacy_camera_info), getString(R.string.privacy_sdcard_info), getString(R.string.privacy_record_info), getString(R.string.privacy_location_info)};
    public RecyclerView.Adapter mAdapter = new a();

    /* loaded from: classes5.dex */
    public static class PermissionDetailHolder extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public TextView f21075a;

        /* renamed from: b  reason: collision with root package name */
        public int f21076b;

        /* renamed from: c  reason: collision with root package name */
        public View.OnClickListener f21077c;

        /* loaded from: classes5.dex */
        public class a implements View.OnClickListener {
            public a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.b.h0.l.a.l(PermissionDetailHolder.this.itemView.getContext(), TbConfig.PRIVACY_DETAIL_URL);
            }
        }

        public PermissionDetailHolder(View view) {
            super(view);
            this.f21076b = 3;
            a aVar = new a();
            this.f21077c = aVar;
            TextView textView = (TextView) view;
            this.f21075a = textView;
            textView.setOnClickListener(aVar);
        }

        public void a(int i) {
            if (i != this.f21076b) {
                SkinManager.setViewTextColor(this.f21075a, R.color.CAM_X0302);
                SkinManager.setBackgroundResource(this.itemView, R.drawable.more_all);
                this.f21076b = i;
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class PermissionViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public TbSettingTextTipView f21079a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f21080b;

        /* renamed from: c  reason: collision with root package name */
        public int f21081c;

        /* renamed from: d  reason: collision with root package name */
        public View.OnClickListener f21082d;

        /* loaded from: classes5.dex */
        public class a implements View.OnClickListener {
            public a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PermissionViewHolder.this.itemView == null) {
                    return;
                }
                Intent intent = new Intent();
                intent.addFlags(268435456);
                intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
                intent.setData(Uri.fromParts("package", PermissionViewHolder.this.itemView.getContext().getPackageName(), null));
                PermissionViewHolder.this.itemView.getContext().startActivity(intent);
            }
        }

        public PermissionViewHolder(View view) {
            super(view);
            this.f21081c = 3;
            this.f21082d = new a();
            TbSettingTextTipView tbSettingTextTipView = (TbSettingTextTipView) view.findViewById(R.id.privacy_name);
            this.f21079a = tbSettingTextTipView;
            tbSettingTextTipView.setOnClickListener(this.f21082d);
            this.f21080b = (TextView) view.findViewById(R.id.privacy_info);
        }

        public void a(b bVar) {
            String string;
            if (bVar == null || this.itemView == null) {
                return;
            }
            this.f21079a.setText(bVar.f21086b);
            TbSettingTextTipView tbSettingTextTipView = this.f21079a;
            if (bVar.f21088d) {
                string = this.itemView.getContext().getString(R.string.privacy_permisson_open);
            } else {
                string = this.itemView.getContext().getString(R.string.privacy_permisson_closed);
            }
            tbSettingTextTipView.setTip(string);
            this.f21080b.setText(bVar.f21087c);
        }

        public void b(int i) {
            if (i != this.f21081c) {
                this.f21079a.f(i);
                SkinManager.setBackgroundResource(this.f21079a, R.drawable.more_all);
                SkinManager.setBackgroundColor(this.f21080b, R.color.CAM_X0204);
                SkinManager.setViewTextColor(this.f21080b, R.color.CAM_X0108);
                this.f21081c = i;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a extends RecyclerView.Adapter {
        public a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return PrivacyPermissionActivity.this.mDataList.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            b bVar = (b) PrivacyPermissionActivity.this.mDataList.get(i);
            if (bVar == null) {
                return 0;
            }
            return bVar.f21085a;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            int itemViewType = getItemViewType(i);
            if (itemViewType == 0) {
                PermissionViewHolder permissionViewHolder = (PermissionViewHolder) viewHolder;
                permissionViewHolder.a((b) PrivacyPermissionActivity.this.mDataList.get(i));
                permissionViewHolder.b(TbadkCoreApplication.getInst().getSkinType());
            } else if (itemViewType == 1) {
                ((PermissionDetailHolder) viewHolder).a(TbadkCoreApplication.getInst().getSkinType());
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            if (i == 0) {
                return new PermissionViewHolder(LayoutInflater.from(PrivacyPermissionActivity.this.getActivity()).inflate(R.layout.layout_privacy_permisson_item, viewGroup, false));
            }
            if (i == 1) {
                return new PermissionDetailHolder(LayoutInflater.from(PrivacyPermissionActivity.this.getActivity()).inflate(R.layout.textview_permission_detail, viewGroup, false));
            }
            return null;
        }
    }

    /* loaded from: classes5.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public int f21085a = 0;

        /* renamed from: b  reason: collision with root package name */
        public String f21086b;

        /* renamed from: c  reason: collision with root package name */
        public String f21087c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f21088d;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        SkinManager.setBackgroundColor(this.mRootView, R.color.CAM_X0204);
        this.mAdapter.notifyDataSetChanged();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.privacy_permission_activity);
        this.mRootView = findViewById(R.id.root_view);
        NavigationBar navigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mNavigationBar = navigationBar;
        navigationBar.showBottomLine();
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(getPageContext().getString(R.string.privacy_permission));
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        this.mRecyclerView = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        this.mRecyclerView.setAdapter(this.mAdapter);
        for (int i = 0; i < this.PERMISSION_ARRAY.length; i++) {
            b bVar = new b();
            bVar.f21085a = 0;
            bVar.f21086b = this.PERMISSION_NAME_ARRAY[i];
            bVar.f21087c = this.PERMISSION_INFO_ARRAY[i];
            this.mDataList.add(bVar);
        }
        b bVar2 = new b();
        bVar2.f21085a = 1;
        this.mDataList.add(bVar2);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.mDataList.size() >= this.PERMISSION_ARRAY.length) {
            for (int i = 0; i < this.PERMISSION_ARRAY.length; i++) {
                this.mDataList.get(i).f21088d = PermissionUtil.checkPermission(getActivity(), this.PERMISSION_ARRAY[i]);
            }
            this.mAdapter.notifyDataSetChanged();
        }
    }
}
