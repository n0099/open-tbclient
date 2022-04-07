package com.baidu.tieba.square.flist;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.square.data.ForumInfoData;
import com.baidu.tieba.square.flist.DirMenuModel;
import com.baidu.tieba.square.flist.ForumListDetailModel;
import com.baidu.tieba.square.flist.ForumListModel;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.a9;
import com.repackage.du4;
import com.repackage.eh8;
import com.repackage.fh8;
import com.repackage.gh8;
import com.repackage.lh8;
import com.repackage.mg;
import com.repackage.ni;
import com.repackage.oi;
import com.repackage.rg;
import com.repackage.vj8;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class ForumListActivity extends BaseActivity<ForumListActivity> implements ViewPager.OnPageChangeListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int HOTTAB = 1;
    public static final int HOT_LIST = 1;
    public static final int INITIAL_ITEM_COUNT = 200;
    public static final String KEY_LEVEL_2_MENU_NAME = "level_2_menu_name";
    public static final String KEY_MENU_ID = "menu_id";
    public static final String KEY_MENU_NAME = "menu_name";
    public static final String KEY_MENU_TYPE = "menu_type";
    public static final String KEY_PARENT_MENU_ID = "parent_menu_id";
    public static final String KEY_PARENT_MENU_NAME = "parent_menu_name";
    public static final int LOAD_MORE_COUNT = 50;
    public static final int RECOMMENDTAB = 0;
    public static final int RECOMMEND_LIST = 0;
    public static final int TYPE_FROM_FRS_int = 2;
    public static boolean isNeedRefreshOnBackFromBarDetail = false;
    public static String sLevel1ID = "";
    public static String sLevel1Name = "";
    public static String sLevel2Name = "";
    public static String sLevelType = "";
    public transient /* synthetic */ FieldHolder $fh;
    public boolean changeMenu;
    public boolean firstIn;
    public boolean isFromTag;
    public boolean isNeedRank;
    public DirMenuModel mDirMenuModel;
    public Drawable mFooterDownwardIcon;
    public Drawable mFooterUpwardIcon;
    public final ForumListDetailModel.b mForumListDetailCallBack;
    public ForumListDetailModel mForumListDetailModel;
    public int mHotCount;
    public fh8 mHotListAdapter;
    public boolean mHotListExpanded;
    public final LikeModel mLikeModel;
    public final DirMenuModel.c mLoadDirDataCallback;
    public final du4.g mOnPullRefreshListener;
    public ForumListModel.RequestParams mParams;
    public int mPostLikeList;
    public int mRecommendCount;
    public fh8 mRecommendListAdapter;
    public boolean mRecommendListExpanded;
    public Drawable mTabLeftBackground;
    public Drawable mTabLeftBackgrounds;
    public Drawable mTabRightBackground;
    public Drawable mTabRightBackgrounds;
    public int mTabStripSelectedTextColor;
    public int mTabStripTextColor;
    public gh8 mViewHolder;
    public final AdapterView.OnItemClickListener menuItemClickListener;
    public int menu_choose;
    public ForumListModel.List recommend_list_left;
    public ForumListModel.List recommend_list_right;
    public int recommend_type_bak;
    public int rn_bak;

    /* loaded from: classes4.dex */
    public class a implements ForumListDetailModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ForumListActivity a;

        public a(ForumListActivity forumListActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumListActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = forumListActivity;
        }

        @Override // com.baidu.tieba.square.flist.ForumListDetailModel.b
        public void a(boolean z, int i, ForumListModel forumListModel, String str, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), forumListModel, str, Boolean.valueOf(z2)}) == null) {
                if (!z && this.a.mRecommendListAdapter.a() == null) {
                    this.a.showToast(str);
                    this.a.mViewHolder.e();
                    this.a.mViewHolder.d();
                    if (this.a.mParams.menu_type == 2 && !z2) {
                        this.a.finish();
                    }
                    this.a.mViewHolder.A.setVisibility(8);
                } else if (forumListModel == null || forumListModel.recommend_list_left == null || forumListModel.recommend_list_right == null || forumListModel.editor_recommend == null || forumListModel.forum_class == null) {
                    if (this.a.mParams.menu_type == 2 && !z2) {
                        ForumListActivity forumListActivity = this.a;
                        forumListActivity.showToast(forumListActivity.getPageContext().getString(R.string.obfuscated_res_0x7f0f0c3c));
                        this.a.finish();
                    } else {
                        this.a.showToast(str);
                        this.a.mViewHolder.d();
                        this.a.mParams.recommend_type = this.a.recommend_type_bak;
                        this.a.mParams.rn = this.a.rn_bak;
                    }
                    this.a.mViewHolder.A.setVisibility(8);
                } else {
                    this.a.mViewHolder.A.setVisibility(8);
                    if (this.a.changeMenu) {
                        ForumListActivity forumListActivity2 = this.a;
                        forumListActivity2.mViewHolder.n.setText(forumListActivity2.getPageContext().getString(R.string.obfuscated_res_0x7f0f0620));
                        ForumListActivity forumListActivity3 = this.a;
                        forumListActivity3.mViewHolder.o.setImageDrawable(forumListActivity3.mFooterDownwardIcon);
                        ForumListActivity forumListActivity4 = this.a;
                        forumListActivity4.mViewHolder.q.setText(forumListActivity4.getPageContext().getString(R.string.obfuscated_res_0x7f0f0620));
                        ForumListActivity forumListActivity5 = this.a;
                        forumListActivity5.mViewHolder.r.setImageDrawable(forumListActivity5.mFooterDownwardIcon);
                        this.a.changeMenu = false;
                    }
                    ForumListActivity forumListActivity6 = this.a;
                    forumListActivity6.mViewHolder.g.setText(forumListActivity6.mParams.menu_name);
                    ForumListActivity forumListActivity7 = this.a;
                    forumListActivity7.mViewHolder.f.onChangeSkinType(forumListActivity7.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
                    ForumListActivity forumListActivity8 = this.a;
                    forumListActivity8.mViewHolder.y.d(forumListActivity8.menu_choose);
                    int min = Math.min(forumListModel.recommend_list_left.forum_list.length, this.a.recommend_list_left.forum_list.length);
                    int min2 = Math.min(forumListModel.recommend_list_right.forum_list.length, this.a.recommend_list_right.forum_list.length);
                    System.arraycopy(forumListModel.recommend_list_left.forum_list, 0, this.a.recommend_list_left.forum_list, 0, min);
                    System.arraycopy(forumListModel.recommend_list_right.forum_list, 0, this.a.recommend_list_right.forum_list, 0, min2);
                    this.a.mRecommendListAdapter.e(min);
                    this.a.mRecommendListAdapter.j(this.a.mLikeModel);
                    this.a.mRecommendListAdapter.f(this.a.recommend_list_left.forum_list);
                    this.a.mViewHolder.i.setSelection(0);
                    if (forumListModel.recommend_list_left.has_more == 1) {
                        this.a.mViewHolder.b.setVisibility(0);
                    } else {
                        this.a.mViewHolder.b.setVisibility(8);
                    }
                    this.a.mViewHolder.k.setText(forumListModel.forum_class[0]);
                    this.a.mHotListAdapter.e(min2);
                    this.a.mHotListAdapter.j(this.a.mLikeModel);
                    this.a.mHotListAdapter.f(this.a.recommend_list_right.forum_list);
                    this.a.mViewHolder.j.setSelection(0);
                    if (forumListModel.recommend_list_right.has_more == 1) {
                        this.a.mViewHolder.c.setVisibility(0);
                    } else {
                        this.a.mViewHolder.c.setVisibility(8);
                    }
                    this.a.mViewHolder.l.setText(forumListModel.forum_class[1]);
                    this.a.findViewById(R.id.obfuscated_res_0x7f090f96).setVisibility(0);
                    this.a.mViewHolder.d();
                    if (this.a.mViewHolder.y.getCount() > 0) {
                        this.a.mViewHolder.z.setClickable(true);
                        ForumListActivity forumListActivity9 = this.a;
                        forumListActivity9.mViewHolder.z.setOnClickListener(forumListActivity9);
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements DirMenuModel.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ForumListActivity a;

        public b(ForumListActivity forumListActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumListActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = forumListActivity;
        }

        @Override // com.baidu.tieba.square.flist.DirMenuModel.c
        public void a(boolean z, int i, lh8 lh8Var, String str, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), lh8Var, str, Boolean.valueOf(z2)}) == null) {
                if (!z || i != 0) {
                    if (z2) {
                        return;
                    }
                    this.a.mViewHolder.e();
                    return;
                }
                lh8Var.e.add(0, lh8Var);
                eh8 eh8Var = this.a.mViewHolder.y;
                if (eh8Var != null) {
                    eh8Var.e(lh8Var);
                    ForumListActivity forumListActivity = this.a;
                    forumListActivity.updateMenuSelectedItem(String.valueOf(forumListActivity.mViewHolder.g.getText()));
                    ForumListActivity forumListActivity2 = this.a;
                    forumListActivity2.mViewHolder.f.onChangeSkinType(forumListActivity2.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
                    this.a.mViewHolder.y.notifyDataSetChanged();
                }
                this.a.mViewHolder.z.setClickable(true);
                ForumListActivity forumListActivity3 = this.a;
                forumListActivity3.mViewHolder.z.setOnClickListener(forumListActivity3);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ForumListActivity a;

        public c(ForumListActivity forumListActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumListActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = forumListActivity;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "forumlist_catalog", "catalogclick", 1, new Object[0]);
                ForumListActivity forumListActivity = this.a;
                rg.d(forumListActivity.mViewHolder.u, forumListActivity.getPageContext().getPageActivity());
                this.a.menu_choose = i;
                this.a.mViewHolder.e();
                this.a.mViewHolder.h();
                ArrayList<lh8> arrayList = this.a.mViewHolder.y.c().e;
                this.a.loadLevel2ForumList(arrayList.get(i).b, arrayList.get(i).c, arrayList.get(i).a);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements du4.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ForumListActivity a;

        public d(ForumListActivity forumListActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumListActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = forumListActivity;
        }

        @Override // com.repackage.du4.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || this.a.mRecommendListAdapter.c() || this.a.mHotListAdapter.c()) {
                return;
            }
            if (this.a.firstIn) {
                this.a.mParams.recommend_type = 0;
                this.a.mParams.rn = 200;
                this.a.mForumListDetailModel.G(this.a.mParams);
                this.a.mForumListDetailModel.loadData();
                this.a.firstIn = false;
            } else if (this.a.mViewHolder.d.getCurrentItem() == 0) {
                if (this.a.mRecommendListExpanded) {
                    this.a.mRecommendCount = 50;
                } else {
                    this.a.mRecommendCount = 200;
                }
                new j(this.a, null).execute(new Void[0]);
            } else if (this.a.mViewHolder.d.getCurrentItem() == 1) {
                if (this.a.mHotListExpanded) {
                    this.a.mHotCount = 50;
                } else {
                    this.a.mHotCount = 200;
                }
                new i(this.a, null).execute(new Void[0]);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ForumListActivity a;

        public e(ForumListActivity forumListActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumListActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = forumListActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.RecommendLoadMore();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ForumListActivity a;

        public f(ForumListActivity forumListActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumListActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = forumListActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.HotLoadMore();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g extends a9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ForumInfoData[] a;
        public final /* synthetic */ ForumListActivity b;

        public g(ForumListActivity forumListActivity, ForumInfoData[] forumInfoDataArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumListActivity, forumInfoDataArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = forumListActivity;
            this.a = forumInfoDataArr;
        }

        @Override // com.repackage.a9
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (this.b.mLikeModel.getErrorCode() == 22) {
                    ForumListActivity forumListActivity = this.b;
                    forumListActivity.showToast(forumListActivity.getPageContext().getString(R.string.obfuscated_res_0x7f0f0803));
                } else if (obj == null) {
                } else {
                    if (this.b.mLikeModel.getErrorCode() != 0) {
                        ForumListActivity forumListActivity2 = this.b;
                        forumListActivity2.showToast(forumListActivity2.mLikeModel.getErrorString());
                    } else if (((vj8) obj).n() == 1) {
                        ForumListActivity forumListActivity3 = this.b;
                        forumListActivity3.showToast(forumListActivity3.getPageContext().getString(R.string.obfuscated_res_0x7f0f02ac));
                        if (this.b.mPostLikeList == 0) {
                            this.b.mRecommendListAdapter.notifyDataSetChanged();
                            TbadkCoreApplication.getInst().addLikeForum(this.a[this.b.mRecommendListAdapter.b].forum_name);
                        } else if (this.b.mPostLikeList == 1) {
                            this.b.mHotListAdapter.notifyDataSetChanged();
                            TbadkCoreApplication.getInst().addLikeForum(this.a[this.b.mHotListAdapter.b].forum_name);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h extends PagerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ForumListActivity a;

        public h(ForumListActivity forumListActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumListActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = forumListActivity;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, viewGroup, i, obj) == null) {
                viewGroup.removeView((View) obj);
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a.isFromTag ? 1 : 2 : invokeV.intValue;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, viewGroup, i)) == null) {
                if (i == 0) {
                    viewGroup.addView(this.a.mViewHolder.i);
                    return this.a.mViewHolder.i;
                } else if (i != 1) {
                    return null;
                } else {
                    viewGroup.addView(this.a.mViewHolder.j);
                    return this.a.mViewHolder.j;
                }
            }
            return invokeLI.objValue;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view2, Object obj) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, view2, obj)) == null) ? view2.equals(obj) : invokeLL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-213183588, "Lcom/baidu/tieba/square/flist/ForumListActivity;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-213183588, "Lcom/baidu/tieba/square/flist/ForumListActivity;");
        }
    }

    public ForumListActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mRecommendCount = 200;
        this.mHotCount = 200;
        this.mPostLikeList = 0;
        this.mLikeModel = new LikeModel(getPageContext());
        this.isFromTag = false;
        this.menu_choose = 0;
        this.changeMenu = false;
        this.recommend_type_bak = 0;
        this.rn_bak = 200;
        this.firstIn = true;
        this.isNeedRank = true;
        this.mRecommendListExpanded = false;
        this.mHotListExpanded = false;
        this.mForumListDetailCallBack = new a(this);
        this.mLoadDirDataCallback = new b(this);
        this.menuItemClickListener = new c(this);
        this.mOnPullRefreshListener = new d(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HotLoadMore() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            if (this.mHotListExpanded) {
                int min = Math.min(this.mHotListAdapter.getCount(), 200);
                this.mHotCount = 200;
                ForumInfoData[] forumInfoDataArr = new ForumInfoData[min];
                System.arraycopy(this.mHotListAdapter.a(), 0, forumInfoDataArr, 0, min);
                this.mHotListAdapter.e(min);
                this.mHotListAdapter.f(forumInfoDataArr);
                this.mHotListExpanded = false;
                this.mViewHolder.q.setText(getPageContext().getString(R.string.obfuscated_res_0x7f0f0620));
                this.mViewHolder.r.setImageDrawable(this.mFooterDownwardIcon);
                return;
            }
            this.mHotCount = 50;
            i iVar = new i(this, null);
            iVar.d(true);
            iVar.execute(new Void[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void RecommendLoadMore() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            if (this.mRecommendListExpanded) {
                int min = Math.min(this.mRecommendListAdapter.getCount(), 200);
                this.mRecommendCount = 200;
                ForumInfoData[] forumInfoDataArr = new ForumInfoData[min];
                System.arraycopy(this.mRecommendListAdapter.a(), 0, forumInfoDataArr, 0, min);
                this.mRecommendListAdapter.e(min);
                this.mRecommendListAdapter.f(forumInfoDataArr);
                this.mRecommendListExpanded = false;
                this.mViewHolder.n.setText(getPageContext().getString(R.string.obfuscated_res_0x7f0f0620));
                this.mViewHolder.o.setImageDrawable(this.mFooterDownwardIcon);
                return;
            }
            this.mRecommendCount = 50;
            j jVar = new j(this, null);
            jVar.d(true);
            jVar.execute(new Void[0]);
        }
    }

    private BdListView buildForumListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65569, this)) == null) {
            BdListView bdListView = new BdListView(getPageContext().getPageActivity());
            bdListView.setScrollingCacheEnabled(false);
            bdListView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            bdListView.setCacheColorHint(0);
            bdListView.setSelector(17170445);
            bdListView.setDivider(new ColorDrawable(0));
            bdListView.setDividerHeight(0);
            bdListView.setFooterDividersEnabled(false);
            bdListView.setHorizontalFadingEdgeEnabled(false);
            bdListView.setVerticalFadingEdgeEnabled(false);
            return bdListView;
        }
        return (BdListView) invokeV.objValue;
    }

    private void initUiAndData(String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65570, this, str, str2, str3, str4) == null) {
            if (ni.isEmpty(str4)) {
                str4 = str;
            }
            this.mViewHolder.g.setText(str4);
            this.mViewHolder.f.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            ForumListModel.RequestParams requestParams = new ForumListModel.RequestParams();
            this.mParams = requestParams;
            requestParams.menu_id = mg.e(str2, 0);
            ForumListModel.RequestParams requestParams2 = this.mParams;
            requestParams2.menu_name = str4;
            requestParams2.menu_type = mg.e(str3, 0);
            this.mParams.parent_menu_id = mg.e(str2, 0);
            ForumListModel.RequestParams requestParams3 = this.mParams;
            requestParams3.parent_menu_name = str;
            requestParams3.offset = 0;
            requestParams3.rn = 10;
            if (requestParams3.menu_id != 0) {
                this.mViewHolder.c();
                this.isFromTag = true;
                this.isNeedRank = false;
                this.mRecommendListAdapter.h(false);
                this.mViewHolder.d.getAdapter().notifyDataSetChanged();
            } else {
                this.isNeedRank = true;
                this.mRecommendListAdapter.h(true);
                this.mViewHolder.g();
            }
            this.recommend_list_left = new ForumListModel.List();
            ForumListModel.List list = new ForumListModel.List();
            this.recommend_list_right = list;
            this.recommend_list_left.forum_list = new ForumInfoData[50];
            list.forum_list = new ForumInfoData[50];
            this.mViewHolder.s.f(this.mOnPullRefreshListener);
            this.mViewHolder.t.f(this.mOnPullRefreshListener);
            this.mRecommendListAdapter.notifyDataSetChanged();
            this.mHotListAdapter.notifyDataSetChanged();
            if (str3.equals("2")) {
                this.mViewHolder.e();
            } else {
                DirMenuModel dirMenuModel = new DirMenuModel(getPageContext(), str, str3, str2);
                this.mDirMenuModel = dirMenuModel;
                dirMenuModel.G(this.mLoadDirDataCallback);
                this.mDirMenuModel.loadData();
            }
            ForumListDetailModel forumListDetailModel = new ForumListDetailModel(getPageContext(), this.mParams);
            this.mForumListDetailModel = forumListDetailModel;
            forumListDetailModel.F(this.mForumListDetailCallBack);
            this.mViewHolder.i.F();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadLevel2ForumList(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65571, this, str, str2, str3) == null) {
            this.mParams.menu_id = mg.e(str2, 0);
            ForumListModel.RequestParams requestParams = this.mParams;
            requestParams.menu_name = str;
            requestParams.menu_type = mg.e(str3, 0);
            this.mParams.parent_menu_id = mg.e(getIntent().getStringExtra("parent_menu_id"), 0);
            this.mParams.parent_menu_name = getIntent().getStringExtra("parent_menu_name");
            ForumListModel.RequestParams requestParams2 = this.mParams;
            requestParams2.offset = 0;
            requestParams2.rn = 10;
            this.recommend_type_bak = requestParams2.recommend_type;
            this.rn_bak = 10;
            requestParams2.recommend_type = 0;
            requestParams2.rn = 200;
            this.changeMenu = true;
            this.mForumListDetailModel.G(requestParams2);
            this.mForumListDetailModel.loadData();
        }
    }

    private View onCreateTabHot() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65572, this)) == null) {
            this.mViewHolder.j = buildForumListView();
            this.mViewHolder.p.setOnClickListener(new f(this));
            return this.mViewHolder.j;
        }
        return (View) invokeV.objValue;
    }

    private View onCreateTabRecommend() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65573, this)) == null) {
            this.mViewHolder.i = buildForumListView();
            this.mViewHolder.m.setOnClickListener(new e(this));
            return this.mViewHolder.i;
        }
        return (View) invokeV.objValue;
    }

    public static void startLevel2ForumListActivity(Context context, String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65574, null, context, str, str2, str3, str4) == null) {
            Intent intent = new Intent(context, ForumListActivity.class);
            intent.putExtra("parent_menu_name", str);
            intent.putExtra("menu_type", str2);
            intent.putExtra("parent_menu_id", str3);
            intent.putExtra(KEY_LEVEL_2_MENU_NAME, str4);
            if (!(context instanceof Activity)) {
                intent.addFlags(LaunchTaskConstants.OTHER_PROCESS);
            }
            context.startActivity(intent);
        }
    }

    public static void updateForumInfo(String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65575, null, str, str2, str3, str4) == null) {
            sLevel1Name = str;
            sLevel1ID = str2;
            sLevelType = str3;
            sLevel2Name = str4;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateMenuSelectedItem(String str) {
        lh8 c2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65576, this, str) == null) || (c2 = this.mViewHolder.y.c()) == null) {
            return;
        }
        ArrayList<lh8> arrayList = c2.e;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (arrayList.get(i2).b.equals(str)) {
                this.menu_choose = i2;
                this.mViewHolder.y.d(i2);
                return;
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        ForumInfoData[] a2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIL(1048576, this, i2, i3, intent) == null) && i2 == 11002 && i3 == -1) {
            this.mForumListDetailModel.loadData();
            if (this.mPostLikeList == 0) {
                a2 = this.mRecommendListAdapter.a();
            } else {
                a2 = this.mHotListAdapter.a();
            }
            this.mLikeModel.setLoadDataCallBack(new g(this, a2));
            if (this.mPostLikeList == 0) {
                LikeModel likeModel = this.mLikeModel;
                int i4 = this.mRecommendListAdapter.b;
                likeModel.P(a2[i4].forum_name, String.valueOf(a2[i4].forum_id));
                return;
            }
            LikeModel likeModel2 = this.mLikeModel;
            int i5 = this.mHotListAdapter.b;
            likeModel2.P(a2[i5].forum_name, String.valueOf(a2[i5].forum_id));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            getLayoutMode().k(i2 == 1);
            getLayoutMode().j(this.mViewHolder.a);
            this.mViewHolder.f.onChangeSkinType(getPageContext(), i2);
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                this.mRecommendListAdapter.d(true);
                this.mHotListAdapter.d(true);
            } else {
                this.mRecommendListAdapter.d(false);
                this.mHotListAdapter.d(false);
            }
            this.mRecommendListAdapter.notifyDataSetChanged();
            this.mHotListAdapter.notifyDataSetChanged();
            PopupWindow popupWindow = this.mViewHolder.u;
            if (popupWindow != null) {
                popupWindow.setBackgroundDrawable(SkinManager.getDrawable(R.drawable.bg_allsproutpop_dropdown));
            }
            SkinManager.setBackgroundResource(this.mViewHolder.e, R.drawable.bg_pop_most);
            this.mTabStripTextColor = SkinManager.getColor(R.color.common_color_10243);
            this.mTabStripSelectedTextColor = SkinManager.getColor(R.color.CAM_X0101);
            this.mTabLeftBackground = SkinManager.getDrawable(R.drawable.btn_pop_most_left_n);
            this.mTabRightBackground = SkinManager.getDrawable(R.drawable.btn_pop_most_right_n);
            this.mTabLeftBackgrounds = SkinManager.getDrawable(R.drawable.btn_pop_most_left_s);
            this.mTabRightBackgrounds = SkinManager.getDrawable(R.drawable.btn_pop_most_right_s);
            this.mFooterDownwardIcon = SkinManager.getDrawable(R.drawable.ico_downward);
            this.mFooterUpwardIcon = SkinManager.getDrawable(R.drawable.ico_upward);
            this.mRecommendListAdapter.i(R.drawable.btn_add_end, R.drawable.btn_add);
            this.mHotListAdapter.i(R.drawable.btn_add_end, R.drawable.btn_add);
            SkinManager.setBackgroundResource(this.mViewHolder.c, R.drawable.bg_black_banner_down);
            SkinManager.setViewTextColor(this.mViewHolder.q, R.color.common_color_10243, 1);
            SkinManager.setBackgroundResource(this.mViewHolder.b, R.drawable.bg_black_banner_down);
            SkinManager.setViewTextColor(this.mViewHolder.n, R.color.common_color_10243, 1);
            if (this.mRecommendListExpanded) {
                SkinManager.setImageResource(this.mViewHolder.o, R.drawable.ico_upward);
            } else {
                SkinManager.setImageResource(this.mViewHolder.o, R.drawable.ico_downward);
            }
            if (this.mHotListExpanded) {
                SkinManager.setImageResource(this.mViewHolder.r, R.drawable.ico_upward);
            } else {
                SkinManager.setImageResource(this.mViewHolder.r, R.drawable.ico_downward);
            }
            if (this.mViewHolder.d.getCurrentItem() == 0) {
                this.mViewHolder.k.setTextColor(this.mTabStripSelectedTextColor);
                this.mViewHolder.k.setBackgroundDrawable(this.mTabLeftBackgrounds);
                this.mViewHolder.l.setBackgroundDrawable(this.mTabRightBackground);
                this.mViewHolder.l.setTextColor(this.mTabStripTextColor);
                return;
            }
            this.mViewHolder.l.setTextColor(this.mTabStripSelectedTextColor);
            this.mViewHolder.l.setBackgroundDrawable(this.mTabRightBackgrounds);
            this.mViewHolder.k.setBackgroundDrawable(this.mTabLeftBackground);
            this.mViewHolder.k.setTextColor(this.mTabStripTextColor);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2) == null) {
            int id = view2.getId();
            if (id == R.id.obfuscated_res_0x7f091e37) {
                this.mViewHolder.d.setCurrentItem(0);
                this.mPostLikeList = 0;
                TiebaStatic.eventStat(view2.getContext(), "recommend_list_click", "click", 1, new Object[0]);
            } else if (id == R.id.obfuscated_res_0x7f091e30) {
                this.mViewHolder.d.setCurrentItem(1);
                this.mPostLikeList = 1;
                TiebaStatic.eventStat(view2.getContext(), "hot_list_click", "click", 1, new Object[0]);
            } else if (id == R.id.obfuscated_res_0x7f092030) {
                this.mViewHolder.f(this.menuItemClickListener);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        int f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.obfuscated_res_0x7f0d02b9);
            String stringExtra = getIntent().getStringExtra("parent_menu_name");
            String stringExtra2 = getIntent().getStringExtra(KEY_LEVEL_2_MENU_NAME);
            String stringExtra3 = getIntent().getStringExtra("parent_menu_id");
            String stringExtra4 = getIntent().getStringExtra("menu_type");
            gh8 gh8Var = new gh8(this);
            this.mViewHolder = gh8Var;
            gh8Var.i = (BdListView) onCreateTabRecommend();
            this.mViewHolder.j = (BdListView) onCreateTabHot();
            this.mViewHolder.A.setVisibility(0);
            this.mViewHolder.z.setOnClickListener(null);
            this.mViewHolder.z.setClickable(false);
            this.mViewHolder.d.setAdapter(new h(this));
            gh8 gh8Var2 = this.mViewHolder;
            gh8Var2.i.setPullRefresh(gh8Var2.s);
            gh8 gh8Var3 = this.mViewHolder;
            gh8Var3.j.setPullRefresh(gh8Var3.t);
            if (mg.e(stringExtra3, 0) != 0) {
                f2 = oi.f(getActivity(), R.dimen.obfuscated_res_0x7f070282);
            } else {
                f2 = oi.f(getActivity(), R.dimen.obfuscated_res_0x7f070260);
            }
            TextView textView = new TextView(getActivity());
            textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + f2));
            this.mViewHolder.i.x(textView, 0);
            TextView textView2 = new TextView(getActivity());
            textView2.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + f2));
            this.mViewHolder.j.x(textView2, 0);
            fh8 fh8Var = new fh8(getPageContext(), 0);
            this.mRecommendListAdapter = fh8Var;
            this.mViewHolder.i.setAdapter((ListAdapter) fh8Var);
            fh8 fh8Var2 = new fh8(getPageContext(), 1);
            this.mHotListAdapter = fh8Var2;
            this.mViewHolder.j.setAdapter((ListAdapter) fh8Var2);
            initUiAndData(stringExtra, stringExtra3, stringExtra4, stringExtra2);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onDestroy();
            LikeModel likeModel = this.mLikeModel;
            if (likeModel != null) {
                likeModel.L();
            }
            this.mViewHolder.d.setAdapter(null);
            this.mViewHolder.j.setAdapter((ListAdapter) null);
            this.mViewHolder.i.setAdapter((ListAdapter) null);
            ListView listView = this.mViewHolder.x;
            if (listView != null) {
                listView.setAdapter((ListAdapter) null);
            }
            DirMenuModel dirMenuModel = this.mDirMenuModel;
            if (dirMenuModel != null) {
                dirMenuModel.cancelLoadData();
            }
            ForumListDetailModel forumListDetailModel = this.mForumListDetailModel;
            if (forumListDetailModel != null) {
                forumListDetailModel.cancelLoadData();
            }
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i2, float f2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2), Integer.valueOf(i3)}) == null) {
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048583, this, i2) == null) || this.isFromTag) {
            return;
        }
        if (i2 == 0) {
            this.mRecommendListAdapter.k();
            this.mRecommendListAdapter.notifyDataSetChanged();
            this.mViewHolder.k.setBackgroundDrawable(this.mTabLeftBackgrounds);
            this.mViewHolder.k.setTextColor(this.mTabStripSelectedTextColor);
            this.mViewHolder.l.setBackgroundDrawable(this.mTabRightBackground);
            this.mViewHolder.l.setTextColor(this.mTabStripTextColor);
        } else if (i2 == 1) {
            this.mHotListAdapter.k();
            this.mHotListAdapter.notifyDataSetChanged();
            this.mViewHolder.l.setBackgroundDrawable(this.mTabRightBackgrounds);
            this.mViewHolder.l.setTextColor(this.mTabStripSelectedTextColor);
            this.mViewHolder.k.setBackgroundDrawable(this.mTabLeftBackground);
            this.mViewHolder.k.setTextColor(this.mTabStripTextColor);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onResume();
            if (isNeedRefreshOnBackFromBarDetail) {
                isNeedRefreshOnBackFromBarDetail = false;
                finish();
                startLevel2ForumListActivity(getPageContext().getPageActivity(), sLevel1Name, sLevelType, sLevel1ID, sLevel2Name);
                return;
            }
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                return;
            }
            fh8 fh8Var = this.mRecommendListAdapter;
            if (fh8Var != null) {
                fh8Var.k();
                this.mRecommendListAdapter.notifyDataSetChanged();
            }
            fh8 fh8Var2 = this.mHotListAdapter;
            if (fh8Var2 != null) {
                fh8Var2.k();
                this.mHotListAdapter.notifyDataSetChanged();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i extends BdAsyncTask<Void, Void, ForumListModel> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;
        public final /* synthetic */ ForumListActivity b;

        public i(ForumListActivity forumListActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumListActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = forumListActivity;
            this.a = false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public ForumListModel doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) {
                try {
                    this.b.mParams.recommend_type = 2;
                    this.b.mParams.offset = 0;
                    this.b.mParams.rn = this.b.mHotCount;
                    return ForumListModel.new_fetch(this.b.mParams);
                } catch (Exception unused) {
                    return null;
                }
            }
            return (ForumListModel) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(ForumListModel forumListModel) {
            ForumListModel.List list;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, forumListModel) == null) {
                if (forumListModel != null && (list = forumListModel.recommend_list_right) != null) {
                    int min = Math.min(list.forum_list.length, this.b.recommend_list_right.forum_list.length);
                    System.arraycopy(forumListModel.recommend_list_right.forum_list, 0, this.b.recommend_list_right.forum_list, 0, min);
                    this.b.mHotListAdapter.e(min);
                    this.b.mHotListAdapter.f(this.b.recommend_list_right.forum_list);
                    if (this.b.mHotCount == 200) {
                        ForumListActivity forumListActivity = this.b;
                        forumListActivity.mViewHolder.q.setText(forumListActivity.getPageContext().getString(R.string.obfuscated_res_0x7f0f0620));
                        ForumListActivity forumListActivity2 = this.b;
                        forumListActivity2.mViewHolder.r.setImageDrawable(forumListActivity2.mFooterDownwardIcon);
                    } else {
                        ForumListActivity forumListActivity3 = this.b;
                        forumListActivity3.mViewHolder.q.setText(forumListActivity3.getPageContext().getString(R.string.obfuscated_res_0x7f0f061f));
                        ForumListActivity forumListActivity4 = this.b;
                        forumListActivity4.mViewHolder.r.setImageDrawable(forumListActivity4.mFooterUpwardIcon);
                        this.b.mHotListExpanded = true;
                    }
                } else {
                    ForumListActivity forumListActivity5 = this.b;
                    forumListActivity5.showToast(forumListActivity5.getPageContext().getString(R.string.obfuscated_res_0x7f0f0c18));
                    if (!this.a) {
                        if (this.b.mHotCount == 200) {
                            ForumListActivity forumListActivity6 = this.b;
                            forumListActivity6.mViewHolder.q.setText(forumListActivity6.getPageContext().getString(R.string.obfuscated_res_0x7f0f0620));
                            ForumListActivity forumListActivity7 = this.b;
                            forumListActivity7.mViewHolder.r.setImageDrawable(forumListActivity7.mFooterDownwardIcon);
                        } else {
                            ForumListActivity forumListActivity8 = this.b;
                            forumListActivity8.mViewHolder.q.setText(forumListActivity8.getPageContext().getString(R.string.obfuscated_res_0x7f0f061f));
                            ForumListActivity forumListActivity9 = this.b;
                            forumListActivity9.mViewHolder.r.setImageDrawable(forumListActivity9.mFooterUpwardIcon);
                        }
                    } else {
                        ForumListActivity forumListActivity10 = this.b;
                        forumListActivity10.mViewHolder.q.setText(forumListActivity10.getPageContext().getString(R.string.obfuscated_res_0x7f0f0620));
                        ForumListActivity forumListActivity11 = this.b;
                        forumListActivity11.mViewHolder.r.setImageDrawable(forumListActivity11.mFooterDownwardIcon);
                        this.b.mParams.rn = 200;
                        this.b.mHotCount = 200;
                    }
                }
                this.b.mViewHolder.p.setEnabled(true);
                this.b.mViewHolder.d();
            }
        }

        public void d(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
                this.a = z;
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                this.b.mViewHolder.p.setEnabled(false);
                ForumListActivity forumListActivity = this.b;
                forumListActivity.mViewHolder.q.setText(forumListActivity.getPageContext().getString(R.string.obfuscated_res_0x7f0f0621));
            }
        }

        public /* synthetic */ i(ForumListActivity forumListActivity, a aVar) {
            this(forumListActivity);
        }
    }

    /* loaded from: classes4.dex */
    public class j extends BdAsyncTask<Void, Void, ForumListModel> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;
        public final /* synthetic */ ForumListActivity b;

        public j(ForumListActivity forumListActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumListActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = forumListActivity;
            this.a = false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public ForumListModel doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) {
                try {
                    this.b.mParams.recommend_type = 1;
                    this.b.mParams.offset = 0;
                    this.b.mParams.rn = this.b.mRecommendCount;
                    return ForumListModel.new_fetch(this.b.mParams);
                } catch (Exception unused) {
                    return null;
                }
            }
            return (ForumListModel) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(ForumListModel forumListModel) {
            ForumListModel.List list;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, forumListModel) == null) {
                if (forumListModel != null && (list = forumListModel.recommend_list_left) != null) {
                    int min = Math.min(list.forum_list.length, this.b.recommend_list_left.forum_list.length);
                    System.arraycopy(forumListModel.recommend_list_left.forum_list, 0, this.b.recommend_list_left.forum_list, 0, min);
                    this.b.mRecommendListAdapter.e(min);
                    this.b.mRecommendListAdapter.f(this.b.recommend_list_left.forum_list);
                    if (this.b.mRecommendCount == 200) {
                        ForumListActivity forumListActivity = this.b;
                        forumListActivity.mViewHolder.n.setText(forumListActivity.getPageContext().getString(R.string.obfuscated_res_0x7f0f0620));
                        ForumListActivity forumListActivity2 = this.b;
                        forumListActivity2.mViewHolder.o.setImageDrawable(forumListActivity2.mFooterDownwardIcon);
                    } else {
                        ForumListActivity forumListActivity3 = this.b;
                        forumListActivity3.mViewHolder.n.setText(forumListActivity3.getPageContext().getString(R.string.obfuscated_res_0x7f0f061f));
                        ForumListActivity forumListActivity4 = this.b;
                        forumListActivity4.mViewHolder.o.setImageDrawable(forumListActivity4.mFooterUpwardIcon);
                        this.b.mRecommendListExpanded = true;
                    }
                } else {
                    ForumListActivity forumListActivity5 = this.b;
                    forumListActivity5.showToast(forumListActivity5.getPageContext().getString(R.string.obfuscated_res_0x7f0f0c18));
                    if (!this.a) {
                        if (this.b.mRecommendCount == 200) {
                            ForumListActivity forumListActivity6 = this.b;
                            forumListActivity6.mViewHolder.n.setText(forumListActivity6.getPageContext().getString(R.string.obfuscated_res_0x7f0f0620));
                            ForumListActivity forumListActivity7 = this.b;
                            forumListActivity7.mViewHolder.o.setImageDrawable(forumListActivity7.mFooterDownwardIcon);
                        } else {
                            ForumListActivity forumListActivity8 = this.b;
                            forumListActivity8.mViewHolder.n.setText(forumListActivity8.getPageContext().getString(R.string.obfuscated_res_0x7f0f061f));
                            ForumListActivity forumListActivity9 = this.b;
                            forumListActivity9.mViewHolder.o.setImageDrawable(forumListActivity9.mFooterUpwardIcon);
                        }
                    } else {
                        ForumListActivity forumListActivity10 = this.b;
                        forumListActivity10.mViewHolder.n.setText(forumListActivity10.getPageContext().getString(R.string.obfuscated_res_0x7f0f0620));
                        ForumListActivity forumListActivity11 = this.b;
                        forumListActivity11.mViewHolder.o.setImageDrawable(forumListActivity11.mFooterDownwardIcon);
                        this.b.mParams.rn = 200;
                        this.b.mRecommendCount = 200;
                    }
                }
                this.b.mViewHolder.m.setEnabled(true);
                this.b.mViewHolder.d();
            }
        }

        public void d(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
                this.a = z;
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                this.b.mViewHolder.m.setEnabled(false);
                ForumListActivity forumListActivity = this.b;
                forumListActivity.mViewHolder.n.setText(forumListActivity.getPageContext().getString(R.string.obfuscated_res_0x7f0f0621));
            }
        }

        public /* synthetic */ j(ForumListActivity forumListActivity, a aVar) {
            this(forumListActivity);
        }
    }
}
