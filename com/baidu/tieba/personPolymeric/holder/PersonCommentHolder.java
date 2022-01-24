package com.baidu.tieba.personPolymeric.holder;

import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import c.a.d.f.p.n;
import c.a.d.n.d.a;
import c.a.t0.z2.c;
import c.a.t0.z2.d;
import c.a.t0.z2.g;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ColumnLayout;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import com.baidu.tieba.personPolymeric.view.ReplyLinearLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes12.dex */
public class PersonCommentHolder extends TypeAdapter.ViewHolder implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: i  reason: collision with root package name */
    public static a f47254i;

    /* renamed from: j  reason: collision with root package name */
    public static String f47255j;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final LinearLayout f47256e;

    /* renamed from: f  reason: collision with root package name */
    public int f47257f;

    /* renamed from: g  reason: collision with root package name */
    public TbPageContext<?> f47258g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f47259h;
    public final LinearLayout mChildLayout;
    public TextView mForumName;
    public final ColumnLayout mItemFooter;
    public final ColumnLayout mItemHeader;
    public TextView mOriginalPostTitle;
    public HeadImageView mPortrait;
    public ReplyLinearLayout mReplyContent;
    public TextView mReplyCount;
    public TextView mReplyTime;
    public LinearLayout mTopLine;
    public TextView mUsername;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PersonCommentHolder(View view, TbPageContext<?> tbPageContext, boolean z) {
        super(view);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view, tbPageContext, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((View) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f47258g = tbPageContext;
        this.f47259h = z;
        ReplyLinearLayout replyLinearLayout = (ReplyLinearLayout) view.findViewById(d.content_container);
        this.mReplyContent = replyLinearLayout;
        replyLinearLayout.setIsHost(this.f47259h);
        this.mOriginalPostTitle = (TextView) view.findViewById(d.original_post_title);
        this.mTopLine = (LinearLayout) view.findViewById(d.top_line);
        this.mPortrait = (HeadImageView) view.findViewById(d.portrait);
        this.mUsername = (TextView) view.findViewById(d.username);
        this.mReplyTime = (TextView) view.findViewById(d.reply_time);
        this.mForumName = (TextView) view.findViewById(d.forum_name);
        this.mReplyCount = (TextView) view.findViewById(d.reply_count);
        this.f47256e = (LinearLayout) view.findViewById(d.item_content);
        this.mItemHeader = (ColumnLayout) view.findViewById(d.item_header);
        this.mItemFooter = (ColumnLayout) view.findViewById(d.item_footer);
        this.mChildLayout = (LinearLayout) view.findViewById(d.person_child);
        this.f47257f = n.d(view.getContext(), 42.0f);
        LinearLayout linearLayout = this.f47256e;
        if (linearLayout != null) {
            linearLayout.setOnClickListener(this);
        }
        this.mPortrait.setOnClickListener(this);
        this.mUsername.setOnClickListener(this);
        this.mForumName.setOnClickListener(this);
        this.mReplyCount.setOnClickListener(this);
        this.mItemHeader.setOnClickListener(this);
        this.mItemFooter.setOnClickListener(this);
        this.mOriginalPostTitle.setOnClickListener(this);
    }

    public final void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            String str2 = f47255j;
            if (str2 != null && !str2.equals(str)) {
                f47254i = null;
            }
            a aVar = f47254i;
            if (aVar != null) {
                this.mPortrait.setImageBitmap(aVar.p());
                f47255j = str;
                return;
            }
            HeadImageView headImageView = this.mPortrait;
            int i2 = this.f47257f;
            headImageView.startLoad(str, 12, i2, i2, false);
        }
    }

    public void changeSkin(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            SkinManager.setBackgroundResource(this.mOriginalPostTitle, c.a.t0.z2.a.CAM_X0205);
            SkinManager.setBackgroundColor(getView(), c.a.t0.z2.a.CAM_X0204);
            SkinManager.setBackgroundResource(this.mChildLayout, c.daily_recommend_item_selector);
            SkinManager.setViewTextColor(this.mUsername, c.a.t0.z2.a.CAM_X0109, 1);
            SkinManager.setViewTextColor(this.mReplyTime, c.a.t0.z2.a.CAM_X0109, 1);
            SkinManager.setViewTextColor(this.mForumName, c.a.t0.z2.a.CAM_X0109, 1);
            SkinManager.setViewTextColor(this.mReplyCount, c.a.t0.z2.a.CAM_X0109, 1);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String[] strArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view) == null) {
            TiebaStatic.log(new StatisticItem("c12043").param("obj_type", this.f47259h ? 1 : 2));
            if (view == this.mForumName) {
                if (this.f47258g != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f47258g.getPageActivity()).createNormalCfg((String) view.getTag(), "")));
                }
            } else if (view != this.mOriginalPostTitle || (strArr = (String[]) view.getTag()) == null || strArr.length < 4 || strArr[3] == null) {
            } else {
                if ("0".equals(strArr[2]) || strArr[1] == null) {
                    PbActivityConfig createNormalCfg = new PbActivityConfig(this.f47258g.getPageActivity()).createNormalCfg(strArr[0], strArr[1], "person_page");
                    createNormalCfg.setStartFrom(4);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
                }
            }
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:38:0x000d */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:29:0x009f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a0  */
    /* JADX WARN: Type inference failed for: r11v10, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r11v11, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r11v12, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r11v9, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r12v13, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r12v15, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r12v19, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r12v21, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r12v26 */
    /* JADX WARN: Type inference failed for: r12v29 */
    /* JADX WARN: Type inference failed for: r12v3 */
    /* JADX WARN: Type inference failed for: r12v30 */
    /* JADX WARN: Type inference failed for: r12v31 */
    /* JADX WARN: Type inference failed for: r12v4 */
    /* JADX WARN: Type inference failed for: r12v6, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r1v6, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r3v10, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v12, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v16 */
    /* JADX WARN: Type inference failed for: r3v9, types: [java.lang.CharSequence, java.lang.Object] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void updateHolderWithData(PersonPostModel.PostInfoList postInfoList, boolean z, String str) {
        Object[] objArr;
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        ?? r12;
        boolean z2;
        ?? r122;
        Object obj5;
        ?? r3;
        ?? r2;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            objArr = new Object[]{postInfoList, Boolean.valueOf(z), str};
            if (interceptable.invokeCommon(1048579, this, objArr) != null) {
                return;
            }
        }
        String[] strArr = new String[4];
        ?? r22 = 1000;
        r22 = 1000;
        Object obj6 = null;
        try {
            try {
                try {
                    try {
                        if (z) {
                            boolean z3 = TextUtils.isEmpty(postInfoList.name_show) ? postInfoList.user_name : postInfoList.name_show;
                            strArr[0] = String.valueOf(postInfoList.thread_id);
                            strArr[1] = String.valueOf(postInfoList.post_id);
                            String formatTime = StringHelper.getFormatTime(postInfoList.create_time * 1000);
                            ?? r32 = postInfoList.forum_name;
                            obj6 = String.valueOf(postInfoList.reply_num);
                            strArr[3] = String.valueOf(postInfoList.thread_type);
                            r22 = formatTime;
                            objArr = r32;
                            z = z3;
                        } else {
                            boolean z4 = TextUtils.isEmpty(postInfoList.name_show) ? postInfoList.user_name : postInfoList.name_show;
                            strArr[0] = String.valueOf(postInfoList.thread_id);
                            strArr[1] = String.valueOf(postInfoList.content[0].post_id);
                            strArr[2] = String.valueOf(postInfoList.content[0].post_type);
                            strArr[3] = String.valueOf(postInfoList.thread_type);
                            String formatTime2 = StringHelper.getFormatTime(postInfoList.create_time * 1000);
                            ?? r33 = postInfoList.forum_name;
                            obj6 = String.valueOf(postInfoList.reply_num);
                            r22 = formatTime2;
                            objArr = r33;
                            z = z4;
                        }
                        z2 = true;
                        r2 = r22;
                        r3 = objArr;
                        r12 = z;
                    } catch (Exception unused) {
                        obj = obj6;
                        obj2 = obj;
                        obj5 = r22;
                        r122 = z;
                        obj6 = r122;
                        obj3 = obj5;
                        obj4 = obj2;
                        r12 = obj6;
                        obj6 = obj;
                        z2 = false;
                        r2 = obj3;
                        r3 = obj4;
                        if (z2) {
                        }
                    }
                } catch (Exception unused2) {
                    obj = null;
                    obj3 = null;
                    obj4 = null;
                    r12 = obj6;
                    obj6 = obj;
                    z2 = false;
                    r2 = obj3;
                    r3 = obj4;
                    if (z2) {
                    }
                }
            } catch (Exception unused3) {
                obj = obj6;
                obj5 = r22;
                obj2 = objArr;
                r122 = z;
                obj6 = r122;
                obj3 = obj5;
                obj4 = obj2;
                r12 = obj6;
                obj6 = obj;
                z2 = false;
                r2 = obj3;
                r3 = obj4;
                if (z2) {
                }
            }
        } catch (Exception unused4) {
            obj = obj6;
            Object obj7 = obj;
            obj2 = obj7;
            obj5 = obj7;
            r122 = z;
            obj6 = r122;
            obj3 = obj5;
            obj4 = obj2;
            r12 = obj6;
            obj6 = obj;
            z2 = false;
            r2 = obj3;
            r3 = obj4;
            if (z2) {
            }
        }
        if (z2) {
            this.mUsername.setText(r12);
            this.mReplyTime.setText(r2);
            this.mForumName.setText(r3);
            this.mForumName.setTag(r3);
            this.mReplyCount.setText(String.format(TbadkCoreApplication.getInst().getContext().getString(g.comment_num_tip), new Object[]{obj6}));
            this.mForumName.setOnClickListener(this);
            a(str);
            LinearLayout linearLayout = this.f47256e;
            if (linearLayout != null) {
                linearLayout.setTag(strArr);
            }
            this.mItemHeader.setTag(strArr);
            this.mItemFooter.setTag(strArr);
        }
    }
}
