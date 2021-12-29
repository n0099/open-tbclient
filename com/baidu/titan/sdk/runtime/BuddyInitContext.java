package com.baidu.titan.sdk.runtime;
/* loaded from: classes13.dex */
public class BuddyInitContext {
    public BuddyInitHolder current;
    public Object genesisObj;
    public BuddyInitHolder head;
    public int initMethodId;
    public BuddyInitHolder last;

    public BuddyInitHolder current() {
        return this.current;
    }

    public BuddyInitHolder last() {
        return this.last;
    }

    public BuddyInitHolder makeNext(int i2, int i3) {
        BuddyInitHolder buddyInitHolder = new BuddyInitHolder(i2, i3);
        if (this.head == null) {
            this.head = buddyInitHolder;
        }
        BuddyInitHolder buddyInitHolder2 = this.current;
        if (buddyInitHolder2 == null) {
            this.current = buddyInitHolder;
        } else {
            buddyInitHolder2.next = buddyInitHolder;
            this.current = buddyInitHolder;
        }
        this.last = buddyInitHolder;
        return buddyInitHolder;
    }

    public BuddyInitHolder moveToFirst() {
        BuddyInitHolder buddyInitHolder = this.head;
        this.current = buddyInitHolder;
        return buddyInitHolder;
    }

    public BuddyInitHolder next() {
        BuddyInitHolder buddyInitHolder = this.current.next;
        this.current = buddyInitHolder;
        return buddyInitHolder;
    }
}
