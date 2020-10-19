package com.baidu.tieba.tblauncher;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
/* loaded from: classes22.dex */
public class f {
    public static void C(Uri uri) {
        if (uri != null) {
            String queryParameter = uri.getQueryParameter("obj_source");
            if (UbcStatConstant.ContentSource.SHOUBAI.equals(queryParameter) || LogConfig.LIVE_SHARE_HK_WEIXIN_FRIEND.equals(queryParameter) || "tbShareH5".equals(queryParameter) || "wise".equals(queryParameter) || "zhongjianye".equals(queryParameter)) {
                String queryParameter2 = uri.getQueryParameter("obj_locate");
                String queryParameter3 = uri.getQueryParameter("obj_type");
                String queryParameter4 = uri.getQueryParameter("obj_param1");
                String queryParameter5 = uri.getQueryParameter(TiebaInitialize.Params.OBJ_PARAM2);
                String queryParameter6 = uri.getQueryParameter(TiebaInitialize.Params.OBJ_PARAM3);
                String queryParameter7 = uri.getQueryParameter("tid");
                String queryParameter8 = uri.getQueryParameter("kw");
                String queryParameter9 = uri.getQueryParameter(com.baidu.tbadk.BdToken.f.eds);
                String queryParameter10 = uri.getQueryParameter(com.baidu.tbadk.BdToken.f.edt);
                String queryParameter11 = uri.getQueryParameter(com.baidu.tbadk.BdToken.f.edu);
                String queryParameter12 = uri.getQueryParameter(com.baidu.tbadk.BdToken.f.edv);
                String queryParameter13 = uri.getQueryParameter("obj_name");
                String queryParameter14 = uri.getQueryParameter("eqid");
                String queryParameter15 = uri.getQueryParameter("is_new_schema");
                if (!TextUtils.isEmpty(queryParameter15) && queryParameter15.equals("1")) {
                    aq aqVar = new aq("c13998");
                    aqVar.dK("obj_source", queryParameter);
                    aqVar.dK("obj_locate", queryParameter2);
                    aqVar.dK("obj_type", queryParameter3);
                    aqVar.dK("obj_param1", queryParameter4);
                    TiebaStatic.log(aqVar);
                    return;
                }
                aq aqVar2 = new aq("c13561");
                aqVar2.dK("obj_locate", queryParameter2);
                aqVar2.dK("obj_type", queryParameter3);
                aqVar2.dK("obj_param1", queryParameter4);
                aqVar2.dK(TiebaInitialize.Params.OBJ_PARAM2, queryParameter5);
                aqVar2.dK(TiebaInitialize.Params.OBJ_PARAM3, queryParameter6);
                aqVar2.dK("tid", queryParameter7);
                aqVar2.dK("fname", queryParameter8);
                aqVar2.dK(com.baidu.tbadk.BdToken.f.eds, queryParameter9);
                aqVar2.dK(com.baidu.tbadk.BdToken.f.edt, queryParameter10);
                aqVar2.dK(com.baidu.tbadk.BdToken.f.edu, queryParameter11);
                aqVar2.dK(com.baidu.tbadk.BdToken.f.edv, queryParameter12);
                aqVar2.dK("obj_source", queryParameter);
                aqVar2.dK("obj_name", queryParameter13);
                aqVar2.dK("query", queryParameter14);
                TiebaStatic.log(aqVar2);
            }
        }
    }

    public static void D(Uri uri) {
        if (uri != null) {
            String queryParameter = uri.getQueryParameter("obj_source");
            if (UbcStatConstant.ContentSource.SHOUBAI.equals(queryParameter) || LogConfig.LIVE_SHARE_HK_WEIXIN_FRIEND.equals(queryParameter) || "tbShareH5".equals(queryParameter) || "wise".equals(queryParameter) || "PC".equals(queryParameter) || "zhongjianye".equals(queryParameter)) {
                String queryParameter2 = uri.getQueryParameter("is_new_schema");
                if (!TextUtils.isEmpty(queryParameter2) && queryParameter2.equals("1")) {
                    aq aqVar = new aq("c13998");
                    aqVar.dK("obj_source", uri.getQueryParameter("obj_source"));
                    aqVar.dK("obj_locate", uri.getQueryParameter("obj_locate"));
                    aqVar.dK("obj_type", uri.getQueryParameter("obj_type"));
                    aqVar.dK("obj_param1", uri.getQueryParameter("obj_param1"));
                    TiebaStatic.log(aqVar);
                }
            }
        }
    }

    public static void E(Uri uri) {
        if (uri != null) {
            String queryParameter = uri.getQueryParameter("obj_source");
            if (UbcStatConstant.ContentSource.SHOUBAI.equals(queryParameter) || LogConfig.LIVE_SHARE_HK_WEIXIN_FRIEND.equals(queryParameter) || "tbShareH5".equals(queryParameter) || "wise".equals(queryParameter) || "PC".equals(queryParameter) || "zhongjianye".equals(queryParameter)) {
                String queryParameter2 = uri.getQueryParameter("obj_locate");
                String queryParameter3 = uri.getQueryParameter("obj_type");
                String queryParameter4 = uri.getQueryParameter("obj_param1");
                String queryParameter5 = uri.getQueryParameter(TiebaInitialize.Params.OBJ_PARAM2);
                String queryParameter6 = uri.getQueryParameter("kw");
                String queryParameter7 = uri.getQueryParameter("obj_name");
                String queryParameter8 = uri.getQueryParameter("fname");
                String queryParameter9 = uri.getQueryParameter("is_new_schema");
                if (!TextUtils.isEmpty(queryParameter9) && queryParameter9.equals("1")) {
                    aq aqVar = new aq("c13998");
                    aqVar.dK("obj_source", queryParameter);
                    aqVar.dK("obj_locate", queryParameter2);
                    aqVar.dK("obj_type", queryParameter3);
                    aqVar.dK("obj_param1", queryParameter4);
                    TiebaStatic.log(aqVar);
                    return;
                }
                aq aqVar2 = new aq("c13561");
                aqVar2.dK("obj_locate", queryParameter2);
                aqVar2.dK("obj_type", queryParameter3);
                aqVar2.dK("obj_param1", queryParameter4);
                aqVar2.dK(TiebaInitialize.Params.OBJ_PARAM2, queryParameter5);
                aqVar2.dK("fname", queryParameter6);
                aqVar2.dK("obj_source", queryParameter);
                aqVar2.dK("obj_name", queryParameter7);
                aqVar2.dK("fname", queryParameter8);
                TiebaStatic.log(aqVar2);
            }
        }
    }

    public static void F(Uri uri) {
        if (uri != null) {
            String queryParameter = uri.getQueryParameter("obj_source");
            if (UbcStatConstant.ContentSource.SHOUBAI.equals(queryParameter) || LogConfig.LIVE_SHARE_HK_WEIXIN_FRIEND.equals(queryParameter) || "tbShareH5".equals(queryParameter) || "wise".equals(queryParameter) || "zhongjianye".equals(queryParameter)) {
                String queryParameter2 = uri.getQueryParameter("obj_locate");
                String queryParameter3 = uri.getQueryParameter("obj_type");
                String queryParameter4 = uri.getQueryParameter("obj_param1");
                String queryParameter5 = uri.getQueryParameter(TiebaInitialize.Params.OBJ_PARAM2);
                String queryParameter6 = uri.getQueryParameter("kw");
                String queryParameter7 = uri.getQueryParameter("obj_name");
                String queryParameter8 = uri.getQueryParameter("topic_id");
                aq aqVar = new aq("c13561");
                aqVar.dK("obj_locate", queryParameter2);
                aqVar.dK("obj_type", queryParameter3);
                aqVar.dK("obj_param1", queryParameter4);
                aqVar.dK(TiebaInitialize.Params.OBJ_PARAM2, queryParameter5);
                aqVar.dK("fname", queryParameter6);
                aqVar.dK("obj_source", queryParameter);
                aqVar.dK("obj_name", queryParameter7);
                aqVar.dK("topic_id", queryParameter8);
                TiebaStatic.log(aqVar);
            }
        }
    }

    public static void G(Uri uri) {
        if (uri != null) {
            String queryParameter = uri.getQueryParameter("obj_source");
            if (UbcStatConstant.ContentSource.SHOUBAI.equals(queryParameter) || LogConfig.LIVE_SHARE_HK_WEIXIN_FRIEND.equals(queryParameter) || "tbShareH5".equals(queryParameter) || "wise".equals(queryParameter) || "zhongjianye".equals(queryParameter)) {
                String queryParameter2 = uri.getQueryParameter("obj_locate");
                String queryParameter3 = uri.getQueryParameter("obj_type");
                String queryParameter4 = uri.getQueryParameter("obj_param1");
                String queryParameter5 = uri.getQueryParameter(TiebaInitialize.Params.OBJ_PARAM2);
                String queryParameter6 = uri.getQueryParameter("obj_name");
                aq aqVar = new aq("c13561");
                aqVar.dK("obj_locate", queryParameter2);
                aqVar.dK("obj_type", queryParameter3);
                aqVar.dK("obj_param1", queryParameter4);
                aqVar.dK(TiebaInitialize.Params.OBJ_PARAM2, queryParameter5);
                aqVar.dK("obj_source", queryParameter);
                aqVar.dK("obj_name", queryParameter6);
                TiebaStatic.log(aqVar);
            }
        }
    }

    public static void H(Uri uri) {
        if (uri != null) {
            String queryParameter = uri.getQueryParameter("obj_source");
            if (UbcStatConstant.ContentSource.SHOUBAI.equals(queryParameter) || LogConfig.LIVE_SHARE_HK_WEIXIN_FRIEND.equals(queryParameter) || "tbShareH5".equals(queryParameter) || "wise".equals(queryParameter) || "PC".equals(queryParameter) || "zhongjianye".equals(queryParameter)) {
                String queryParameter2 = uri.getQueryParameter("obj_locate");
                String queryParameter3 = uri.getQueryParameter("obj_type");
                String queryParameter4 = uri.getQueryParameter("obj_param1");
                String queryParameter5 = uri.getQueryParameter(TiebaInitialize.Params.OBJ_PARAM2);
                uri.getQueryParameter("kw");
                String queryParameter6 = uri.getQueryParameter("obj_name");
                uri.getQueryParameter("fname");
                aq aqVar = new aq("c13561");
                aqVar.dK("obj_locate", queryParameter2);
                aqVar.dK("obj_type", queryParameter3);
                aqVar.dK("obj_param1", queryParameter4);
                aqVar.dK(TiebaInitialize.Params.OBJ_PARAM2, queryParameter5);
                aqVar.dK("obj_source", queryParameter);
                aqVar.dK("obj_name", queryParameter6);
                TiebaStatic.log(aqVar);
            }
        }
    }
}
